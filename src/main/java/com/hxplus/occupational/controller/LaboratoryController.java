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

import com.hxplus.occupational.model.Laboratory;
import com.hxplus.occupational.request.LaboratoryRequest;
import com.hxplus.occupational.service.LaboratoryService;

@Controller
@RequestMapping(value="laboratory")
public class LaboratoryController {
	@Autowired LaboratoryService laboratoryService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Laboratory getLaboratory(@PathVariable("id") Long id){
		return laboratoryService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Laboratory> getLaboratorys(){
		return laboratoryService.findAll();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Laboratory createLaboratory(@RequestBody LaboratoryRequest laboratoryRequest){
		return laboratoryService.saveLaboratory(laboratoryRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Laboratory updateLaboratory(@PathVariable("id") Long id, @RequestBody LaboratoryRequest laboratoryRequest){
		return laboratoryService.updateLaboratory(id, laboratoryRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteLaboratory(@PathVariable("id") Long id){
		return laboratoryService.deleteLaboratory(id);
	}
}
