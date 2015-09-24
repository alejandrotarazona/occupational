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

import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.request.PatientRequest;
import com.hxplus.occupational.service.PatientService;

@Controller
@RequestMapping(value="patient")
public class PatientController {
	@Autowired PatientService patientService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Patient getPatient(@PathVariable("id") Long id){
		return patientService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Patient> getPatients(){
		return patientService.findAll();
	}
	
	@RequestMapping(value="/{id}/listPatients", method=RequestMethod.GET)
	public @ResponseBody List<Patient> listByDoctor(@PathVariable("id") Long id){
		return patientService.listByDoctor(id);
	}
	
	@RequestMapping(value="/{idUser}/doctor/{idDoc}",method= RequestMethod.POST)
	public @ResponseBody Patient createPatient(@PathVariable("idUser") Long idUser,@PathVariable("idDoc") Long idDoc, @RequestBody PatientRequest patientRequest){
		System.out.println(patientRequest);
		System.out.println(patientRequest.getHistory());
		System.out.println(patientRequest.getUser());
		System.out.println(patientRequest.getDoctors());
		return patientService.savePatient(idUser, idDoc, patientRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Patient updatePatient(@PathVariable("id") Long id, @RequestBody PatientRequest patientRequest){
		return patientService.updatePatient(id, patientRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deletePatient(@PathVariable("id") Long id){
		return patientService.deletePatient(id);
	}
}
