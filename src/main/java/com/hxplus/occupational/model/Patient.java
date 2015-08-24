package com.hxplus.occupational.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.print.Doc;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "patient")
@PrimaryKeyJoinColumn(name = "id")
public class Patient extends User {

	private History history;
	private List<Doctor> doctors;

	@OneToOne(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(referencedColumnName = "id")
	public History getHistory() {
		return history;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "attends", inverseJoinColumns= { @JoinColumn(name = "iddoctor", referencedColumnName = "id") }, joinColumns = { @JoinColumn(referencedColumnName = "id", name = "idpatient") })
	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

}
