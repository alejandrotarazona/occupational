package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Patient;


public class AllergyRequest {

	private String name;
	private String description;
	private String severity;
	private Patient patient;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getSeverity() {
		return severity;
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

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public void setPatient(Patient patient) {
		this.patient= patient;
	}

}
