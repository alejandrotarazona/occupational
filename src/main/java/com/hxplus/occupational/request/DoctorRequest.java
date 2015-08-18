package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Patient;

public class DoctorRequest extends UserRequest {

	private Long regNumber;
	private List<Patient> patients;

	public Long getRegNumber() {
		return regNumber;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setRegNumber(Long regNumber) {
		this.regNumber = regNumber;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
