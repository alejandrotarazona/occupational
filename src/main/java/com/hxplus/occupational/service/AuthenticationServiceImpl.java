package com.hxplus.occupational.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.User;
import com.hxplus.occupational.repositories.UserRepository;
import com.hxplus.occupational.request.LoginRequest;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private static final String key = new BigInteger(130, new SecureRandom()).toString(32).substring(0, 25);
	private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	
	@Autowired
	UserRepository userRepository;
	
	

	public static String getKey() {
		return key;
	}

	public static SignatureAlgorithm getSignaturealgorithm() {
		return signatureAlgorithm;
	}

	@Override
	public Map<String, Object> login(LoginRequest loginRequest) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword()); 
		
		if ( user != null) {			
			long nowMillis = System.currentTimeMillis();
			Date now = new Date(nowMillis), exp = new Date(nowMillis + 43200000);
			
			String jti = String.valueOf(user.getId());
			
			String retorno = Jwts.builder()
					.setId(jti)
					.setSubject(loginRequest.getUsername())
					.setIssuedAt(now)
					.setExpiration(exp)
					.signWith(signatureAlgorithm, key).compact();
			
			
			System.out.println("Date:\t" + now.toString());
			System.out.println("System key:\t " + key);
			System.out.println("System token:\t " + retorno);
			
			map.put("user", user);
			map.put("token", retorno);
		}

		return map;
	}

	@Override
	public ResponseEntity<Object> logout() {

		return null;
	}

	@SuppressWarnings("unused")
	private void parseJWT(String jwt) {
		// This line will throw an exception if it is not a signed JWS (as
		// expected)
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
		
		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());
	}

}
