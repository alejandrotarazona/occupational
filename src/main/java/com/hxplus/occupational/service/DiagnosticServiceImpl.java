package com.hxplus.occupational.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Diagnostic;
import com.hxplus.occupational.model.Instruction;
import com.hxplus.occupational.repositories.DiagnosticRepository;
import com.hxplus.occupational.request.DiagnosticRequest;
import com.hxplus.occupational.request.InstructionRequest;

@Service
public class DiagnosticServiceImpl implements DiagnosticService {
	@Autowired
	DiagnosticRepository diagnosticRepository;
	@Autowired
	InstructionService instructionService;

	@Override
	public Diagnostic findById(Long id) {
		return diagnosticRepository.findOne(id);
	}

	@Override
	public List<Diagnostic> findAll() {
		return diagnosticRepository.findAll();
	}

	@Override
	public List<Diagnostic> findByPatientId(Long idPantient) {
		return diagnosticRepository.findByPatientId(idPantient);
	}

	@Override
	public List<Diagnostic> findByConsultId(Long idConsult) {
		return diagnosticRepository.findByConsultId(idConsult);
	}

	@Override
	public Diagnostic saveDiagnostic(DiagnosticRequest diagnosticRequest) {
		Diagnostic diagnostic = diagnosticRepository.save(fromReq(
				new Diagnostic(), diagnosticRequest));

		List<Instruction> instructions = new ArrayList<>();

		for (InstructionRequest instructionRequest : diagnosticRequest
				.getInstructions()) {
			instructions.add(instructionService
					.saveInstruction(instructionRequest));
		}

		diagnostic.setInstructions(instructions);

		return diagnosticRepository.save(diagnostic);
	}

	@Override
	public Diagnostic updateDiagnostic(Long id,
			DiagnosticRequest diagnosticRequest) {
		return diagnosticRepository.save(fromReq(findById(id),
				diagnosticRequest));
	}

	@Override
	public ResponseEntity<Object> deleteDiagnostic(Long id) {
		try {
			diagnosticRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Diagnostic fromReq(Diagnostic diagnostic,
			DiagnosticRequest diagnosticRequest) {

		diagnostic.setDetails(diagnosticRequest.getDetails());
		diagnostic.setConsult(diagnosticRequest.getConsult());
		diagnostic.setExam(diagnosticRequest.getExam());

		return diagnostic;
	}

}
