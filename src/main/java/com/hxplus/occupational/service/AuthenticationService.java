package com.hxplus.occupational.service;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.User;
import com.hxplus.occupational.request.LoginRequest;

public interface AuthenticationService {
	
	public User login(LoginRequest loginRequest);
	public ResponseEntity<Object> logout();

}
