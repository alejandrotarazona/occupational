package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Instruction;
import com.hxplus.occupational.repositories.InstructionRepository;
import com.hxplus.occupational.request.InstructionRequest;

@Service
public class InstructionServiceImpl implements InstructionService {

	@Autowired
	InstructionRepository instructionRepository;

	@Override
	public Instruction findById(Long id) {
		return instructionRepository.findOne(id);
	}

	@Override
	public List<Instruction> findAll() {
		return instructionRepository.findAll();
	}

	@Override
	public List<Instruction> findByConsultId(Long idConsult) {
		System.out.println("Consult ID: "+ idConsult);
		List<Instruction> instructions = instructionRepository.findByConsultId(idConsult);
		return instructions;
	}

	@Override
	public Instruction saveInstruction(InstructionRequest instructionRequest) {
		return instructionRepository.save(fromReq(new Instruction(),
				instructionRequest));
	}

	@Override
	public Instruction updateInstruction(Long id,
			InstructionRequest instructionRequest) {
		return instructionRepository.save(fromReq(findById(id),
				instructionRequest));
	}

	@Override
	public ResponseEntity<Object> deleteInstruction(Long id) {
		try {
			instructionRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Instruction fromReq(Instruction instruction,
			InstructionRequest instructionRequest) {
		instruction.setInstruction(instructionRequest.getInstruction());
		instruction.setDiagnostics(instructionRequest.getDiagnostics());
		instruction.setConsult(instructionRequest.getConsult());

		return instruction;
	}
}
