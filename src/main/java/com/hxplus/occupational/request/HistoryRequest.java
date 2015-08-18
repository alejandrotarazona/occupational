package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Allergy;
import com.hxplus.occupational.model.Background;
import com.hxplus.occupational.model.Habit;
import com.hxplus.occupational.model.User;
import com.hxplus.occupational.model.Vaccine;

public class HistoryRequest {
	private Long id;
	private Background background;
	private List<Allergy> allergies;
	private List<Vaccine> vaccines;
	private List<Habit> habits;
	private User user;

	public Long getId() {
		return id;
	}

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

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setUser(User user) {
		this.user = user;
	}

}
