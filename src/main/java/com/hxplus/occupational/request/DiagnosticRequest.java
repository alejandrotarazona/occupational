package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.Exam;

public class DiagnosticRequest {

	private Consult consult;
	private Exam exam;
	private List<InstructionRequest> instructions;
	private String details;

	public Consult getConsult() {
		return consult;
	}

	public Exam getExam() {
		return exam;
	}

	public List<InstructionRequest> getInstructions() {
		return instructions;
	}

	public String getDetails() {
		return details;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public void setInstructions(List<InstructionRequest> instructions) {
		this.instructions = instructions;
	}

}
