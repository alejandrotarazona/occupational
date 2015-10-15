package com.hxplus.occupational.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxplus.occupational.model.User;
import com.hxplus.occupational.request.UserRequest;
import com.hxplus.occupational.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	User getUser(@PathVariable("id") Long id) {
		//return userService.createUser(new User());
		return userService.findById(id);
	}
	
	@RequestMapping(value = "/master", method = RequestMethod.GET)
	public @ResponseBody
	User getUser() {
		return userService.createUser(new User());
	}
	
	@RequestMapping(value= "/listnopatient")
	public @ResponseBody List<User> listNoPatient(){
		return userService.listNoPatients();
	}
	
	@RequestMapping(value = "/patient/{idpatient}", method = RequestMethod.GET)
	public @ResponseBody User getUserByPatient(@PathVariable("idpatient") Long idpatient){
		return userService.fingByPatientId(idpatient);
	}
	

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<User> getUsers() {
		return userService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	User createUser(@RequestBody UserRequest userRequest) {
		return userService.saveUser(userRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	User updateUser(@PathVariable("id") Long id,
			@RequestBody UserRequest userRequest) {
		return userService.updateUser(id, userRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
		return userService.deleteUser(id);
	}

}
