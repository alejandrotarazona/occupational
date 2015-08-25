package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.Diagnostic;

public class InstructionRequest {

	private String instruction;
	private Consult consult;
	private List<Diagnostic> diagnostics;

	public String getInstruction() {
		return instruction;
	}

	public Consult getConsult() {
		return consult;
	}

	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setDiagnostics(List<Diagnostic> diagnostics) {
		this.diagnostics = diagnostics;
	}

}
