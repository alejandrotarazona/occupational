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
@Table(name="background")
public class Background {

	private Long id;
	private String name;
	private String description;
	private Patient patient;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPatient(Patient patient) {
		this.patient= patient;
	}

	
}
