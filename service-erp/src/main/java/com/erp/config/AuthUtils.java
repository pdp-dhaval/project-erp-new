package com.erp.config;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import model.common.AuthRequest;
import model.common.AuthResponse;
import utils.CommonUtils;

public class AuthUtils {

	public static final String GRANT_TYPE = "password";
	public static final String CLIENT_ID = "cw";
	public static final String CLIENT_SECRET = "cw";
	
	public static final String OAUTH_TOKEN_URI = "/oauth/token";
	public static final String OAUTH_CHECK_TOKEN_URI = "/oauth/check_token";
	
	public static final String ACCESS_TOKEN = "erp_ac_tk";
	public static final String REFRESH_TOKEN = "erp_rf_tk";
	public static final String USER_NAME = "erp_us_nm";
	public static final String LOGIN_TOKEN = "erp_lg_tk";
	
	public static AuthRequest convertHttpToModel(HttpServletRequest request) {
		AuthRequest authRequest = new AuthRequest();
		if(!CommonUtils.isObjectNullOrEmpty(request)) {
			authRequest.setAccessToken(decode(request.getHeader(ACCESS_TOKEN)));
			authRequest.setRefreshToken(decode(request.getHeader(REFRESH_TOKEN)));
			authRequest.setLoginToken(Integer.valueOf(decode(request.getHeader(LOGIN_TOKEN))));
			authRequest.setUsername(decode(request.getHeader(REFRESH_TOKEN)));
		}
		return authRequest;
	}
	
	public static AuthResponse encodeHeaders(AuthResponse response) {
		response.setAccess_token(encode(response.getAccess_token()));
		response.setRefresh_token(encode(response.getRefresh_token()));
		response.setLoginToken(encode(response.getLoginToken()));
		response.setUsername(encode(response.getUsername()));
		return response;
	}
	
	public static String encode(String str) {
		if (str == null || "".equals(str)) {
			return null;
		}
		try {
			return Base64.getEncoder().encodeToString(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String decode(String str) {
		if (str == null || "".equals(str)) {
			return null;
		}
		try {
			byte[] value = Base64.getDecoder().decode(str);
			return new String(value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
