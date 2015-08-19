package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.Diagnostic;

public class InstructionRequest {
	
	private Long id;
	private String instruction;
	private List<Diagnostic> diagnostics;
	private Consult consult;

	public Long getId() {
		return id;
	}

	public String getInstruction() {
		return instruction;
	}

	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	public Consult getConsult() {
		return consult;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public void setDiagnostics(List<Diagnostic> diagnostics) {
		this.diagnostics = diagnostics;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

}
