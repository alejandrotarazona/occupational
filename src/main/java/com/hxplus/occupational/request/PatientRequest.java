package com.hxplus.occupational.request;

import java.util.List;

public class PatientRequest {

	private UserRequest user;
	private List<DoctorRequest> doctors;

	public UserRequest getUser() {
		return user;
	}

	public List<DoctorRequest> getDoctors() {
		return doctors;
	}

	public void setUser(UserRequest user) {
		this.user = user;
	}

	public void setDoctors(List<DoctorRequest> doctors) {
		this.doctors = doctors;
	}

}
