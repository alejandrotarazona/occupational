package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.model.User;

public class DoctorRequest {

	private User user;
	private Long regNumber;
	private List<Patient> patients;
	private List<Consult> consults;

	public User getUser() {
		return user;
	}

	public Long getRegNumber() {
		return regNumber;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public List<Consult> getConsults() {
		return consults;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setRegNumber(Long regNumber) {
		this.regNumber = regNumber;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public void setConsults(List<Consult> consults) {
		this.consults = consults;
	}

}
