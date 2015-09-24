package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.repositories.AllergyRepository;
import com.hxplus.occupational.repositories.HabitRepository;

public class HistoryRequest {

	private BackgroundRequest background;
	private List<AllergyRepository> allergies;
	private List<HabitRepository> habits;
	private List<VaccineRequest> vaccines;
	private PatientRequest patient;

	public BackgroundRequest getBackground() {
		return background;
	}

	public List<AllergyRepository> getAllergies() {
		return allergies;
	}

	public List<HabitRepository> getHabits() {
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

	public void setAllergies(List<AllergyRepository> allergies) {
		this.allergies = allergies;
	}

	public void setHabits(List<HabitRepository> habits) {
		this.habits = habits;
	}

	public void setVaccines(List<VaccineRequest> vaccines) {
		this.vaccines = vaccines;
	}

	public void setPatient(PatientRequest patient) {
		this.patient = patient;
	}

}
