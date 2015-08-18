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

import com.hxplus.occupational.model.Diagnostic;
import com.hxplus.occupational.request.DiagnosticRequest;
import com.hxplus.occupational.service.DiagnosticService;

@Controller
@RequestMapping(value="diagnostic")
public class DiagnosticController {
	@Autowired DiagnosticService diagnosticService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Diagnostic getDiagnostic(@PathVariable("id") Long id){
		return diagnosticService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Diagnostic> getDiagnostics(){
		return diagnosticService.findAll();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Diagnostic createDiagnostic(@RequestBody DiagnosticRequest diagnosticRequest){
		return diagnosticService.saveDiagnostic(diagnosticRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Diagnostic updateDiagnostic(@PathVariable("id") Long id, @RequestBody DiagnosticRequest diagnosticRequest){
		return diagnosticService.updateDiagnostic(id, diagnosticRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteDiagnostic(@PathVariable("id") Long id){
		return diagnosticService.deleteDiagnostic(id);
	}
}