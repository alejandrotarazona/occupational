package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.Diagnostic;

public class InstructionRequest {
	
	private String instruction;
	private Diagnostic diagnostic;
	private Consult consult;

	public String getInstruction() {
		return instruction;
	}

	public Diagnostic getDiagnostic() {
		return diagnostic;
	}

	public Consult getConsult() {
		return consult;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public void setDiagnostic(Diagnostic diagnostic) {
		this.diagnostic = diagnostic;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

}
