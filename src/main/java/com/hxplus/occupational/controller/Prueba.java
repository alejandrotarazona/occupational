package com.hxplus.occupational.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.Drug;
import com.hxplus.occupational.model.Laboratory;
import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.model.Post;
import com.hxplus.occupational.model.User;
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
		List<Object> objects = new ArrayList<>(); 
		objects.addAll(initService.initCompanies());
		objects.addAll(initService.initLaboratories());
		objects.addAll(initService.initDrugs());
		objects.addAll(initService.initPosts());
		objects.addAll(initService.initUsers());
		objects.addAll(initService.initDoctors());
		objects.addAll(initService.initPatients());
		return objects;
	}
	
	@RequestMapping(value="initCompanies",method=RequestMethod.GET)
	public @ResponseBody List<Company> initCompanies(){
		return initService.initCompanies();
	}
	
	@RequestMapping(value="initLaboratories",method=RequestMethod.GET)
	public @ResponseBody List<Laboratory> initLaboratories(){
		return initService.initLaboratories();
	}
	@RequestMapping(value="initDrugs",method=RequestMethod.GET)
	public @ResponseBody List<Drug> initDrugs(){
		return initService.initDrugs();
	}
	
	@RequestMapping(value="initPosts" , method = RequestMethod.GET)
	public @ResponseBody List<Post> initPosts(){
		return initService.initPosts();
	}
	
	@RequestMapping(value="initUsers",method=RequestMethod.GET)
	public @ResponseBody List<User> initUsers(){
		return initService.initUsers();
	}
	
	@RequestMapping(value="initDoctors",method=RequestMethod.GET)
	public @ResponseBody List<Doctor> initDoctors(){
		return initService.initDoctors();
	}
	
	@RequestMapping(value="initPatients",method=RequestMethod.GET)
	public @ResponseBody List<Patient> initPatients(){
		return initService.initPatients();
	}

}
