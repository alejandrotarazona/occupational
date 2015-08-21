package com.hxplus.occupational.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prescription")
public class Prescription {

	private Long id;
	private Doctor doctor;
	private List<Drug> drugs;
	private List<Indication> indications;
	private Date date;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id")
	public Doctor getDoctor() {
		return doctor;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id")
	public List<Drug> getDrugs() {
		return drugs;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id")
	public List<Indication> getIndications() {
		return indications;
	}

	@Column(name="date")
	public Date getDate() {
		return date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public void setIndications(List<Indication> indications) {
		this.indications = indications;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
