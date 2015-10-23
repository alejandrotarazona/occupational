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

import com.hxplus.occupational.model.Exam;
import com.hxplus.occupational.request.ExamRequest;
import com.hxplus.occupational.service.ExamService;

@Controller
@RequestMapping(value="exam")
public class ExamController {
	@Autowired ExamService examService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Exam getExam(@PathVariable("id") Long id){
		return examService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Exam> getExams(){
		return examService.findAll();
	}
	
	@RequestMapping(value="/pending/bypatient/{id}", method=RequestMethod.GET)
	public @ResponseBody List<Exam> getPendingExams(@PathVariable("id") Long idPatient){
		return examService.findPendingByPatient(idPatient);
	}
	
	@RequestMapping(value="/requested/byconsult/{id}", method= RequestMethod.GET)
	public @ResponseBody List<Exam> findRequestedByConsult(@PathVariable("id") Long idConsult){
		return examService.findRequestedByConsult(idConsult);
	}
	
	@RequestMapping(value="/received/byconsult/{id}", method= RequestMethod.GET)
	public @ResponseBody List<Exam> findRecievedByConsult(@PathVariable("id") Long idConsult){
		return examService.findRecievedByConsult(idConsult);
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Exam createExam(@RequestBody ExamRequest examRequest){
		return examService.saveExam(examRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Exam updateExam(@PathVariable("id") Long id, @RequestBody ExamRequest examRequest){
		return examService.updateExam(id, examRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteExam(@PathVariable("id") Long id){
		return examService.deleteExam(id);
	}
}

