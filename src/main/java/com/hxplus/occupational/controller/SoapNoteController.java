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

import com.hxplus.occupational.model.SoapNote;
import com.hxplus.occupational.request.SoapNoteRequest;
import com.hxplus.occupational.service.SoapNoteService;

@Controller
@RequestMapping(value="soapnote")
public class SoapNoteController {
	@Autowired SoapNoteService soapNoteService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody SoapNote getSoapNote(@PathVariable("id") Long id){
		return soapNoteService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<SoapNote> getSoapNotes(){
		return soapNoteService.findAll();
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody SoapNote createSoapNote(@RequestBody SoapNoteRequest soapNoteRequest){
		return soapNoteService.saveSoapNote(soapNoteRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody SoapNote updateSoapNote(@PathVariable("id") Long id, @RequestBody SoapNoteRequest soapNoteRequest){
		return soapNoteService.updateSoapNote(id, soapNoteRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteSoapNote(@PathVariable("id") Long id){
		return soapNoteService.deleteSoapNote(id);
	}
}