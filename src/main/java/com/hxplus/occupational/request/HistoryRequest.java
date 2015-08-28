package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Allergy;
import com.hxplus.occupational.model.Background;
import com.hxplus.occupational.model.Habit;
import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.model.Vaccine;

public class HistoryRequest {
	private Background background;
	private List<Allergy> allergies;
	private List<Vaccine> vaccines;
	private List<Habit> habits;
	private Patient patient;

	public Background getBackground() {
		return background;
	}

	public List<Allergy> getAllergies() {
		return allergies;
	}

	public List<Vaccine> getVaccines() {
		return vaccines;
	}

	public List<Habit> getHabits() {
		return habits;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	public void setAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
	}

	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}

	public void setHabits(List<Habit> habits) {
		this.habits = habits;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
