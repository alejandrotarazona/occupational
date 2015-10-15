package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Patient;

public class HabitRequest {

	private String name;
	private String frecuency;
	private Patient patient;

	public String getName() {
		return name;
	}

	public String getFrecuency() {
		return frecuency;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
