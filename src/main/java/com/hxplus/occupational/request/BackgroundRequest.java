package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Patient;

public class BackgroundRequest {

	private String name;
	private String description;
	private Patient patient;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
