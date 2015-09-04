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

import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.request.DoctorRequest;
import com.hxplus.occupational.service.DoctorService;

@Controller
@RequestMapping(value="doctor")
public class DoctorController {
	@Autowired DoctorService doctorService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Doctor getDoctor(@PathVariable("id") Long id){
		return doctorService.findById(id);
	}
	
	@RequestMapping(value="/{id}/dashboard",method=RequestMethod.GET)
	public @ResponseBody Doctor getDoctorWithPatients(@PathVariable("id") Long id){
		return doctorService.findByIdAndFetchPatientsEagerly(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Doctor> getDoctors(){
		return doctorService.findAll();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Doctor createDoctor(@RequestBody DoctorRequest doctorRequest){
		return doctorService.saveDoctor(doctorRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Doctor updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorRequest doctorRequest){
		return doctorService.updateDoctor(id, doctorRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteDoctor(@PathVariable("id") Long id){
		return doctorService.deleteDoctor(id);
	}
}
