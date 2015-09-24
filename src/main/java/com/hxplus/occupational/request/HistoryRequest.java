package com.hxplus.occupational.request;

import java.util.List;

public class HistoryRequest {

	private BackgroundRequest background;
	private List<AllergyRequest> allergies;
	private List<HabitRequest> habits;
	private List<VaccineRequest> vaccines;
	private PatientRequest patient;

	public BackgroundRequest getBackground() {
		return background;
	}

	public List<AllergyRequest> getAllergies() {
		return allergies;
	}

	public List<HabitRequest> getHabits() {
		return habits;
	}

	public List<VaccineRequest> getVaccines() {
		return vaccines;
	}

	public PatientRequest getPatient() {
		return patient;
	}

	public void setBackground(BackgroundRequest background) {
		this.background = background;
	}

	public void setAllergies(List<AllergyRequest> allergies) {
		this.allergies = allergies;
	}

	public void setHabits(List<HabitRequest> habits) {
		this.habits = habits;
	}

	public void setVaccines(List<VaccineRequest> vaccines) {
		this.vaccines = vaccines;
	}

	public void setPatient(PatientRequest patient) {
		this.patient = patient;
	}

}
