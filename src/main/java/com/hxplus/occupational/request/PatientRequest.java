package com.hxplus.occupational.request;

import java.util.List;

public class PatientRequest {

	private HistoryRequest history;
	private UserRequest user;
	private List<DoctorRequest> doctors;

	public HistoryRequest getHistory() {
		return history;
	}

	public UserRequest getUser() {
		return user;
	}

	public List<DoctorRequest> getDoctors() {
		return doctors;
	}

	public void setHistory(HistoryRequest history) {
		this.history = history;
	}

	public void setUser(UserRequest user) {
		this.user = user;
	}

	public void setDoctors(List<DoctorRequest> doctors) {
		this.doctors = doctors;
	}

}
