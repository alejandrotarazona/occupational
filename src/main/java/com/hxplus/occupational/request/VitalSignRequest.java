package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Consult;

public class VitalSignRequest {
	
	private Consult consult;
	private String name;
	private String descripion;

	public Consult getConsult() {
		return consult;
	}

	public String getName() {
		return name;
	}

	public String getDescripion() {
		return descripion;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

}
