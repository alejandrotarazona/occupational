package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Instruction;
import com.hxplus.occupational.request.InstructionRequest;

public interface InstructionService {
	

	public Instruction findById(Long id);
	public List<Instruction> findAll();
	public List<Instruction> findByConsultId(Long idConsult);
	public Instruction saveInstruction(InstructionRequest instructionRequest);
	public Instruction updateInstruction(Long id, InstructionRequest instructionRequest);
	public ResponseEntity<Object> deleteInstruction(Long id);

}
