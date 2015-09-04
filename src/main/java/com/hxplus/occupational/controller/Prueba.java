package com.hxplus.occupational.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxplus.occupational.service.InitService;

@Controller
@RequestMapping(value="/")
public class Prueba {
	
	@Autowired InitService initService;
	
	@RequestMapping(value="hola",method=RequestMethod.GET)
	public @ResponseBody String holaMundo(){
		return "Hola Mundo";
	}
	
	@RequestMapping(value="init",method=RequestMethod.GET)
	public @ResponseBody List<Object> init(){
		return initService.init();
	}

}
