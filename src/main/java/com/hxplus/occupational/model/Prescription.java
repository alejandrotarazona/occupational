package com.hxplus.occupational.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "prescription")
public class Prescription {

	private Long id;
	private Doctor doctor;
	private Drug drug;
	private Indication indication;
	private Date date;
	private Consult consult;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="iddoctor", referencedColumnName = "id")
	public Doctor getDoctor() {
		return doctor;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddrug", referencedColumnName = "id")
	public Drug getDrug() {
		return drug;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idindication", referencedColumnName = "id")
	public Indication getIndication() {
		return indication;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idconsult", referencedColumnName = "id")
	@JsonBackReference
	public Consult getConsult() {
		return consult;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public void setIndication(Indication indication) {
		this.indication = indication;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

}
