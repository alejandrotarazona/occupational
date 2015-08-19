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

import com.hxplus.occupational.model.Indication;
import com.hxplus.occupational.request.IndicationRequest;
import com.hxplus.occupational.service.IndicationService;

@Controller
@RequestMapping(value="indication")
public class IndicationController {
	@Autowired IndicationService indicationService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Indication getIndication(@PathVariable("id") Long id){
		return indicationService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Indication> getIndications(){
		return indicationService.findAll();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Indication createIndication(@RequestBody IndicationRequest indicationRequest){
		return indicationService.saveIndication(indicationRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Indication updateIndication(@PathVariable("id") Long id, @RequestBody IndicationRequest indicationRequest){
		return indicationService.updateIndication(id, indicationRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteIndication(@PathVariable("id") Long id){
		return indicationService.deleteIndication(id);
	}
}