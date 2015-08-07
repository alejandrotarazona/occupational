package com.hxplus.occupational.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxplus.occupational.request.LoginRequest;
import com.hxplus.occupational.service.AuthenticationService;

@Controller
@RequestMapping(value = "/")
public class AutenticationController {

	@Autowired AuthenticationService authenticationService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody LoginRequest loginRequest){
		String retorno =  authenticationService.login(loginRequest);
		System.out.println(retorno);
		return retorno;
	}
	
	public @ResponseBody ResponseEntity<Object> logout(){
		return authenticationService.logout();
	}

}
