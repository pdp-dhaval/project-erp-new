package com.erp.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.erp.config.AuthUtils;
import com.erp.service.UserTokenMappingService;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.common.AuthRequest;
import model.common.AuthResponse;
import utils.CommonUtils;


@RestController
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private Environment environment;

	private static final String OAUTH_URL_KEY = "capitaworld.auth.base.url";

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private UserTokenMappingService userTokenMappingService;
	
	@RequestMapping(value = "/login")
	public String testApi() {
		logger.info("Call Test Api");
		return "Successfully test api called";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
		logger.info("Enter in Login Service");
		String oauthToken = environment.getRequiredProperty(OAUTH_URL_KEY).concat(AuthUtils.OAUTH_TOKEN_URI);
		String url = oauthToken.concat("?username=" + authRequest.getUsername() + "&password="
				+ authRequest.getPassword() + "&grant_type=" + AuthUtils.GRANT_TYPE);
		RestTemplate restTemplate = new RestTemplate();
		AuthResponse response = null;
		try {
			ResponseEntity<String> responseInString = null;
			try {
				responseInString = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<String>(createHeader()),String.class);	
			}catch (Exception e) {
				logger.info("Something went wrong when call auth api fo check username and password");
				e.printStackTrace();
			}
			if(!CommonUtils.isObjectNullOrEmpty(responseInString)) {
				// convert response to AuthResponse class
				response = responseAdapter(responseInString.getBody());
				response= userTokenMappingService.createNewUserWithToken(response,authRequest);
				logger.info("Successfully Generate Refreshtoken-----------------" + authRequest.getUsername());
				return new ResponseEntity<AuthResponse>(AuthUtils.encodeHeaders(response),HttpStatus.OK);	
			} else {
				return new ResponseEntity<AuthResponse>(new AuthResponse("Invalid email or password",HttpStatus.UNAUTHORIZED.value()),HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error("Throw Exception While Login User");
			e.printStackTrace();
			return new ResponseEntity<AuthResponse>(new AuthResponse("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR.value()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/getAccessToken", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AuthResponse getAccessToken(@RequestBody AuthRequest authRequest) {
		logger.info("Enter in get accessToken");
		String checkOauthTokenUrl = environment.getRequiredProperty(OAUTH_URL_KEY)
				.concat(AuthUtils.OAUTH_TOKEN_URI);
		String url = checkOauthTokenUrl
				.concat("?grant_type=refresh_token&refresh_token=" + authRequest.getRefreshToken());
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<String> responseInString = restTemplate.exchange(url, HttpMethod.GET,
					new HttpEntity<String>(createHeader(AuthUtils.CLIENT_ID, AuthUtils.CLIENT_SECRET)),
					String.class);
			AuthResponse response = responseAdapter(responseInString.getBody());
			response.setUsername(authRequest.getUsername());
			response.setLoginToken(authRequest.getLoginToken().toString());
			userTokenMappingService.updateAccessToken(response);
			logger.info("Successfully Generate Accesstoken---" + authRequest.getUsername());
			return response;
		} catch (Exception e) {
			printLog("getAccessToken",authRequest);
			logger.error("Throw Exception While Generate New Access Token");
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/checkAccessToken", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AuthResponse checkAccessToken(@RequestBody AuthRequest req) {
		logger.info("Enter in check accessToken");
		// first we check oauth check token using oauth/check_token
		String oauthCheckToken = environment.getRequiredProperty(OAUTH_URL_KEY)
				.concat(AuthUtils.OAUTH_CHECK_TOKEN_URI);
		String url = oauthCheckToken.concat("?token=" + req.getAccessToken());
		boolean isValid = validateAccessTokenWithOauth(req, url);
		AuthResponse response = new AuthResponse();
		if (isValid) {
			response = userTokenMappingService.checkAccessToken(req);
			if (response.getUserId() != null) {
				response.setAuthenticate(true);
			} else {
				printLog("CheckAccessToken", req);
				logger.warn("Check AccessToken on Every Request, Invalid Accesstoken or Refreshtoken or Logintoken");
				response.setAuthenticate(false);
			}
			return response;
		}
		printLog("CheckAccessToken", req);
		logger.warn("Check AccessToken on Every Request, AccessToken is Expire or Invalid");
		response.setAuthenticate(false);
		return response;
	}
	
	@RequestMapping(value = "/logoutUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AuthResponse logoutUser(@RequestBody AuthRequest request) {
		logger.info("Enter in logout user");
		AuthResponse response = new AuthResponse();
		response.setAuthenticate(false);
		try {
			if (!StringUtils.isEmpty(request.getAccessToken()) && !StringUtils.isEmpty(request.getUsername())) {
				if(userTokenMappingService.isUserAlreadyActive(request.getUsername(), request.getRefreshToken())){
					OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(request.getAccessToken());
					if (oAuth2AccessToken != null) {
						tokenStore.removeAccessToken(oAuth2AccessToken);
					}
				}
				userTokenMappingService.logoutuser(request);
				logger.info("Successfully logoutUser----" + request.getUsername() + "---LoginToken----" + request.getLoginToken());
				response.setAuthenticate(true);
			} else {
				printLog("Logout User", request);
				logger.warn("Logout User, Token and username not valid");
				response.setMessage("Token and username is not valid");
			}
			return response;
		} catch (Exception e) {
			printLog("Logout User", request);
			logger.error("Throw exception while logout user");
			e.printStackTrace();
			return response;
		}
	}
	
	
	private boolean validateAccessTokenWithOauth(AuthRequest req, String url) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.exchange(url, HttpMethod.GET,
					new HttpEntity<String>(createHeader(req.getClientId(), req.getClientSecret())), String.class);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	private HttpHeaders createHeader(String clientId, String clientSecret) {
		String authSecret = clientId + ":" + clientSecret;
		HttpHeaders headers = new HttpHeaders();
		headers.set("authorization", "Basic " + Base64Utils.encodeToString(authSecret.getBytes()));
		headers.set("cache-control", "no-cache");
		return headers;
	}
	
	private String printLog(String method,AuthRequest authRequest) {
		return method + ", AccessToken ----->" + authRequest.getAccessToken()+ "<-----RefresToken----->" + authRequest.getRefreshToken()
		+"<---------UserName------->"+authRequest.getUsername() + "<---------LoginToken ------>" + authRequest.getLoginToken();
	}
	
	/**
	 * CREATE REQUEST HEADER FOR AUTHORIZATION
	 * 
	 * @param clientId
	 * @param clientSecret
	 * @return
	 */
	private HttpHeaders createHeader() {
		String authSecret = AuthUtils.CLIENT_ID + ":" + AuthUtils.CLIENT_SECRET;
		HttpHeaders headers = new HttpHeaders();
		headers.set("authorization", "Basic " + Base64Utils.encodeToString(authSecret.getBytes()));
		headers.set("cache-control", "no-cache");
		return headers;
	}
	
	/**
	 * CONVERT RESPONSE STRING TO AuthResponse OBJECT
	 * 
	 * @param response
	 * @return
	 */
	private AuthResponse responseAdapter(String response) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(response, AuthResponse.class);
		} catch (Exception e) {
			logger.info("Response String -----------------> " +response);
			logger.error("Throw exception when convert string response to object");
			e.printStackTrace();
			return null;
		}
	}

	
	
}
