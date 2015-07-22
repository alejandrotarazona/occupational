package com.hxplus.occupational.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.User;
import com.hxplus.occupational.repositories.UserRepository;
import com.hxplus.occupational.request.LoginRequest;

public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired UserRepository userRepository;

	@Override
	public User login(LoginRequest loginRequest) {
		return userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
	}

	@Override
	public ResponseEntity<Object> logout() {
		
		return null;
	}
	
}
