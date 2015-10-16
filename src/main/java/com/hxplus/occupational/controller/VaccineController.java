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

import com.hxplus.occupational.model.Vaccine;
import com.hxplus.occupational.request.VaccineRequest;
import com.hxplus.occupational.service.VaccineService;

@Controller
@RequestMapping(value="vaccine")
public class VaccineController {
	@Autowired VaccineService vaccineService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Vaccine getVaccine(@PathVariable("id") Long id){
		return vaccineService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Vaccine> getVaccines(){
		return vaccineService.findAll();
	}
	
	@RequestMapping(value="/bypatient/{idpatient}", method= RequestMethod.GET)
	public @ResponseBody List<Vaccine> listBackgroundsByPatient(@PathVariable("idpatient") Long idpatient){
		return vaccineService.findByPatientId(idpatient);
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Vaccine createVaccine(@RequestBody VaccineRequest vaccineRequest){
		return vaccineService.saveVaccine(vaccineRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Vaccine updateVaccine(@PathVariable("id") Long id, @RequestBody VaccineRequest vaccineRequest){
		return vaccineService.updateVaccine(id, vaccineRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteVaccine(@PathVariable("id") Long id){
		return vaccineService.deleteVaccine(id);
	}
}
