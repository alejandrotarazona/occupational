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

import com.hxplus.occupational.model.Allergy;
import com.hxplus.occupational.request.AllergyRequest;
import com.hxplus.occupational.service.AllergyService;

@Controller
@RequestMapping(value="allergy")
public class AllergyController {
	@Autowired AllergyService allergyService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Allergy getAllergy(@PathVariable("id") Long id){
		return allergyService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Allergy> getAllergys(){
		return allergyService.findAll();
	}
	
	@RequestMapping(value="/bypatient/{idpatient}", method= RequestMethod.GET)
	public @ResponseBody List<Allergy> listBackgroundsByPatient(@PathVariable("idpatient") Long idpatient){
		return allergyService.findByPatientId(idpatient);
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Allergy createAllergy(@RequestBody AllergyRequest allergyRequest){
		return allergyService.saveAllergy(allergyRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Allergy updateAllergy(@PathVariable("id") Long id, @RequestBody AllergyRequest allergyRequest){
		return allergyService.updateAllergy(id, allergyRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteAllergy(@PathVariable("id") Long id){
		return allergyService.deleteAllergy(id);
	}
}

