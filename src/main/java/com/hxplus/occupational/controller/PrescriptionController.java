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

import com.hxplus.occupational.model.Prescription;
import com.hxplus.occupational.request.PrescriptionRequest;
import com.hxplus.occupational.service.PrescriptionService;

@Controller
@RequestMapping(value="prescription")
public class PrescriptionController {
	@Autowired PrescriptionService prescriptionService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Prescription getPrescription(@PathVariable("id") Long id){
		return prescriptionService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Prescription> getPrescriptions(){
		return prescriptionService.findAll();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Prescription createPrescription(@RequestBody PrescriptionRequest prescriptionRequest){
		return prescriptionService.savePrescription(prescriptionRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Prescription updatePrescription(@PathVariable("id") Long id, @RequestBody PrescriptionRequest prescriptionRequest){
		return prescriptionService.updatePrescription(id, prescriptionRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deletePrescription(@PathVariable("id") Long id){
		return prescriptionService.deletePrescription(id);
	}
}