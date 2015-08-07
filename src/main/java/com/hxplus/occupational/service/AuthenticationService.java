package com.hxplus.occupational.service;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.request.LoginRequest;

public interface AuthenticationService {
	
	public String login(LoginRequest loginRequest);
	public ResponseEntity<Object> logout();

}
