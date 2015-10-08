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

import com.hxplus.occupational.model.VitalSign;
import com.hxplus.occupational.request.VitalSignRequest;
import com.hxplus.occupational.service.VitalSignService;

@Controller
@RequestMapping(value="vitalsign")
public class VitalSignController {
	@Autowired VitalSignService vitalSignService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody VitalSign getVitalSign(@PathVariable("id") Long id){
		return vitalSignService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<VitalSign> getVitalSigns(){
		return vitalSignService.findAll();
	}
	
	@RequestMapping(value="/names", method=RequestMethod.GET)
	public @ResponseBody List<VitalSign> getVitalSignsNames(){
		return vitalSignService.findAllNames();
	};
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody VitalSign createVitalSign(@RequestBody VitalSignRequest vitalSignRequest){
		return vitalSignService.saveVitalSign(vitalSignRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody VitalSign updateVitalSign(@PathVariable("id") Long id, @RequestBody VitalSignRequest vitalSignRequest){
		return vitalSignService.updateVitalSign(id, vitalSignRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteVitalSign(@PathVariable("id") Long id){
		return vitalSignService.deleteVitalSign(id);
	}
}