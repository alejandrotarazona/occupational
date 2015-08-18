package com.hxplus.occupational.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History {

	private Long id;
	private Background background;
	private List<Allergy> allergies;
	private List<Vaccine> vaccines;
	private List<Habit> habits;
	private User user;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	public Background getBackground() {
		return background;
	}

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	public List<Allergy> getAllergies() {
		return allergies;
	}

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	public List<Vaccine> getVaccines() {
		return vaccines;
	}

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	public List<Habit> getHabits() {
		return habits;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id")
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
