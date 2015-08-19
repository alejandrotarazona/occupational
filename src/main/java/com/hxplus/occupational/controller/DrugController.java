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

import com.hxplus.occupational.model.Drug;
import com.hxplus.occupational.request.DrugRequest;
import com.hxplus.occupational.service.DrugService;

@Controller
@RequestMapping(value="drug")
public class DrugController {
	@Autowired DrugService drugService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Drug getDrug(@PathVariable("id") Long id){
		return drugService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Drug> getDrugs(){
		return drugService.findAll();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Drug createDrug(@RequestBody DrugRequest drugRequest){
		return drugService.saveDrug(drugRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Drug updateDrug(@PathVariable("id") Long id, @RequestBody DrugRequest drugRequest){
		return drugService.updateDrug(id, drugRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteDrug(@PathVariable("id") Long id){
		return drugService.deleteDrug(id);
	}
}