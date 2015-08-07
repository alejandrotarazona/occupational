package com.hxplus.occupational.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.repositories.UserRepository;
import com.hxplus.occupational.request.LoginRequest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired UserRepository userRepository;

	@Override
	public String login(LoginRequest loginRequest) {
		if (userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword()) != null){
			return Jwts.builder().setSubject(loginRequest.getUsername()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact(); // Cambiar "secretkey"
		}
		
		return null;
	}

	@Override
	public ResponseEntity<Object> logout() {
		
		return null;
	}
	
}
