package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Consult;

public class VitalSignRequest {
	
	private Consult consult;
	private String name;
	private String description;

	public Consult getConsult() {
		return consult;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
