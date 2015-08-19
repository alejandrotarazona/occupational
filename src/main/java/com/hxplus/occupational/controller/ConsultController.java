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

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.request.ConsultRequest;
import com.hxplus.occupational.service.ConsultService;

@Controller
@RequestMapping(value="consult")
public class ConsultController {
	@Autowired ConsultService consultService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Consult getConsult(@PathVariable("id") Long id){
		return consultService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Consult> getConsults(){
		return consultService.findAll();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Consult createConsult(@RequestBody ConsultRequest consultRequest){
		return consultService.saveConsult(consultRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Consult updateConsult(@PathVariable("id") Long id, @RequestBody ConsultRequest consultRequest){
		return consultService.updateConsult(id, consultRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteConsult(@PathVariable("id") Long id){
		return consultService.deleteConsult(id);
	}
}

