package com.hxplus.occupational.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.request.LoginRequest;

public interface AuthenticationService {
	
	public Map<String, Object> login(LoginRequest loginRequest);
	public ResponseEntity<Object> logout();

}
