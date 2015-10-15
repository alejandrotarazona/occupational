package com.hxplus.occupational.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vaccine")
public class Vaccine {

	private Long id;
	private String name;
	private String potency;
	private Patient patient;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "potency")
	public String getPotency() {
		return potency;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.LAZY)
	@JoinColumn(name="idpatient", referencedColumnName="id")
	@JsonBackReference
	public Patient getPatient() {
		return patient;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPotency(String potency) {
		this.potency = potency;
	}

	public void setPatient(Patient patient) {
		this.patient= patient;
	}
}
