package com.hxplus.occupational.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "patient")
public class Patient extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7746973037890360513L;
	
	private Long id;
	private User user;
	private List<Background> backgrounds;
	private List<Allergy> allergies;
	private List<Vaccine> vaccines;
	private List<Habit> habits;
	private List<Consult> consults;
	private List<Doctor> doctors;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "iduser", referencedColumnName = "id")
	public User getUser() {
		return user;
	}
	

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "attends", inverseJoinColumns = { @JoinColumn(name = "iddoctor", referencedColumnName = "id") }, joinColumns = { @JoinColumn(referencedColumnName = "id", name = "idpatient") })
	public List<Doctor> getDoctors() {
		return doctors;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "patient")
	@JsonManagedReference
	public List<Background> getBackgrounds() {
		return backgrounds;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "patient")
	@JsonManagedReference
	public List<Allergy> getAllergies() {
		return allergies;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "patient")
	@JsonManagedReference
	public List<Vaccine> getVaccines() {
		return vaccines;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "patient")
	@JsonManagedReference
	public List<Habit> getHabits() {
		return habits;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.MERGE, mappedBy="patient")
	@JsonManagedReference
	public List<Consult> getConsults() {
		return consults;
	}

	public void setBackgrounds(List<Background> backgrounds) {
		this.backgrounds = backgrounds;
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

	public void setConsults(List<Consult> consults) {
		this.consults = consults;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
