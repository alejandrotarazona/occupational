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

import com.hxplus.occupational.model.Instruction;
import com.hxplus.occupational.request.InstructionRequest;
import com.hxplus.occupational.service.InstructionService;

@Controller
@RequestMapping(value="instruction")
public class InstructionController {
	@Autowired InstructionService instructionService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Instruction getInstruction(@PathVariable("id") Long id){
		return instructionService.findById(id);
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public @ResponseBody List<Instruction> getInstructions(){
		return instructionService.findAll();
	}
	
	@RequestMapping(value="/byconsult/{id}", method=RequestMethod.GET)
	public @ResponseBody List<Instruction> getInstructions(@PathVariable("id") Long idConsult){
		return instructionService.findByConsultId(idConsult);
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public @ResponseBody Instruction createInstruction(@RequestBody InstructionRequest instructionRequest){
		return instructionService.saveInstruction(instructionRequest);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody Instruction updateInstruction(@PathVariable("id") Long id, @RequestBody InstructionRequest instructionRequest){
		return instructionService.updateInstruction(id, instructionRequest);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Object> deleteInstruction(@PathVariable("id") Long id){
		return instructionService.deleteInstruction(id);
	}
}