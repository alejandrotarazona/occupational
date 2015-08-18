package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Consult;

public class SoapNoteRequest {
	private Consult consult;
	private String description;

	public Consult getConsult() {
		return consult;
	}

	public String getDescription() {
		return description;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
