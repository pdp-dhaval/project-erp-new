package com.erp.service.master.impl;


import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.domain.User;
import com.erp.domain.UserTokenMapping;
import com.erp.repository.common.UserRepository;
import com.erp.repository.common.UserTokenMappingRepository;
import com.erp.service.UserTokenMappingService;

import model.common.AuthRequest;
import model.common.AuthResponse;

@Service
@Transactional
public class UserTokenMappingServiceImpl implements UserTokenMappingService{

	public static Random random = new Random();
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTokenMappingRepository userTokenMappingRepository;
	
	
	@Override
	public AuthResponse createNewUserWithToken(AuthResponse response,AuthRequest authRequest) {
		
		UserTokenMapping userTokenMapping = new UserTokenMapping();
		userTokenMapping.setAccessToken(response.getAccess_token());
		userTokenMapping.setRefreshToken(response.getRefresh_token());
		userTokenMapping.setExpiresIn(response.getExpires_in());
		userTokenMapping.setActive(true);
		userTokenMapping.setLoginDate(new Date());
		userTokenMapping.setUserIp(authRequest.getUserIp());
		userTokenMapping.setUserBrowser(authRequest.getUserBrowser());
		userTokenMapping.setDomainIsactive(authRequest.getIsDomainLogin());
		Integer randomNumber = getRandomNumber();
		userTokenMapping.setLoginToken(randomNumber);
		User user = userRepository.findOneByEmail(authRequest.getUsername());
		if(user != null){
			userTokenMapping.setUserId(user.getErpId());
		}
		userTokenMappingRepository.save(userTokenMapping);
		response.setLoginToken(userTokenMapping.getLoginToken().toString());
		response.setUsername(authRequest.getUsername());
		return response;
	}
	
	@Override
	public void updateAccessToken(AuthResponse response) {
		userTokenMappingRepository.updateAccessToken(response.getUsername(), response.getRefresh_token(), response.getAccess_token(), response.getExpires_in(), Integer.valueOf(response.getLoginToken()));
	}
	
	@Override
	public AuthResponse checkAccessToken(AuthRequest authRequest) {
		List<UserTokenMapping> userTokenMapping = userTokenMappingRepository.checkAccessToken(authRequest.getUsername(), authRequest.getAccessToken(),authRequest.getLoginToken());
		AuthResponse response = new AuthResponse();
		if(userTokenMapping.isEmpty() || userTokenMapping == null) {
			return response;
		} else {
			response.setUserId(userTokenMapping.get(0).getUserId());
			response.setUserType(userTokenMapping.get(0).getUserType());
			return response;
		}
	}
	
	@Override
	public void logoutuser(AuthRequest req){
		userTokenMappingRepository.logoutUser(req.getUsername(),req.getRefreshToken(),req.getLoginToken());
	}
	
	@Override
	public boolean isUserAlreadyActive(String userName,String refreshToken){
		Long count = userTokenMappingRepository.isUserAlreadyActive(userName, refreshToken);
		return count > 0;
	}
	
	private Integer getRandomNumber() {
		Integer randomNumber = 1000000 + random.nextInt(9000000);
		Long count = userTokenMappingRepository.checkLoginToken(randomNumber);
		if(count > 0) {
			getRandomNumber();
		}
		return 1000000 + random.nextInt(9000000);
	}

	
}
