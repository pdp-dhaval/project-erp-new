package com.erp.service;

import model.common.AuthRequest;
import model.common.AuthResponse;

public interface UserTokenMappingService {

	public AuthResponse createNewUserWithToken(AuthResponse response,AuthRequest authRequest);
	
	public void updateAccessToken(AuthResponse response);
	
	public AuthResponse checkAccessToken(AuthRequest authRequest);
	
	public void logoutuser(AuthRequest req);
	
	public boolean isUserAlreadyActive(String userName,String refreshToken);
}
