package com.hxplus.occupational.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2970196982338363111L;
	private Long id;
	private User user;
	private Long regNumber;
	private List<Patient> patients;
	private List<Consult> consults;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "iduser", referencedColumnName = "id")
	public User getUser() {
		return user;
	}

	@Column(name = "regnumber")
	public Long getRegNumber() {
		return regNumber;
	}

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "attends", joinColumns = { @JoinColumn(name = "iddoctor", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(referencedColumnName = "id", name = "idpatient") })
	public List<Patient> getPatients() {
		return patients;
	}

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "doctor")
	public List<Consult> getConsults() {
		return consults;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setRegNumber(Long regNumber) {
		this.regNumber = regNumber;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public void setConsults(List<Consult> consults) {
		this.consults = consults;
	}

}
