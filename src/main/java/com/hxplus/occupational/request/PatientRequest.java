package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.History;
import com.hxplus.occupational.model.User;

public class PatientRequest extends UserRequest {

	private User user;
	private History history;
	private List<Doctor> doctors;

	public User getUser() {
		return user;
	}

	public History getHistory() {
		return history;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

}
