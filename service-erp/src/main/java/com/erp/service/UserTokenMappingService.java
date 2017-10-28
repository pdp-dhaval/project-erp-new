package com.erp.service;

import model.common.AuthRequest;
import model.common.AuthResponse;

public interface UserTokenMappingService {

	public AuthResponse createNewUserWithToken(AuthResponse response,AuthRequest authRequest);
}
