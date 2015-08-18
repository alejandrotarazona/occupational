package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Consult;

public class DiagnosticRequest {

	private Consult consult;
	private String details;

	public Consult getConsult() {
		return consult;
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

}
