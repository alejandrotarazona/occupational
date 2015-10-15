package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Patient;

public class VaccineRequest {

	private String name;
	private String potency;
	private Patient patient;

	public String getName() {
		return name;
	}

	public String getPotency() {
		return potency;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPotency(String potency) {
		this.potency = potency;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
