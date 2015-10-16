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

import com.hxplus.occupational.model.Background;
import com.hxplus.occupational.request.BackgroundRequest;
import com.hxplus.occupational.service.BackgroundService;

@Controller
@RequestMapping(value="background")
public class BackgroundController {
	@Autowired BackgroundService backgroundService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Background getBackground(@PathVariable("id") Long id){
		return backgroundService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Background> getBackgrounds(){
		return backgroundService.findAll();
	}
	
	@RequestMapping(value="/bypatient/{idpatient}", method= RequestMethod.GET)
	public @ResponseBody List<Background> listBackgroundsByPatient(@PathVariable("idpatient") Long idpatient){
		return backgroundService.findByPatientId(idpatient);
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Background createBackground(@RequestBody BackgroundRequest backgroundRequest){
		return backgroundService.saveBackground(backgroundRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Background updateBackground(@PathVariable("id") Long id, @RequestBody BackgroundRequest backgroundRequest){
		return backgroundService.updateBackground(id, backgroundRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteBackground(@PathVariable("id") Long id){
		return backgroundService.deleteBackground(id);
	}
}
