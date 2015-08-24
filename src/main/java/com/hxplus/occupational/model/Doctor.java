package com.hxplus.occupational.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
@PrimaryKeyJoinColumn(name = "id")
public class Doctor extends User {

	private Long regNumber;
	private List<Patient> patients;
	private List<Consult> consults;
	
	@Column(name = "regnumber")
	public Long getRegNumber() {
		return regNumber;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "attends", joinColumns = { @JoinColumn(name = "iddoctor", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(referencedColumnName = "id", name = "idpatient") })
	public List<Patient> getPatients() {
		return patients;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy="doctor")
	public List<Consult> getConsults(){
		return consults;
	}

	public void setRegNumber(Long regNumber) {
		this.regNumber = regNumber;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
