package com.hxplus.occupational.request;

import java.util.Date;
import java.util.List;

import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.Drug;
import com.hxplus.occupational.model.Indication;

public class PrescriptionRequest {

	private Long id;
	private Doctor doctor;
	private List<Drug> drugs;
	private List<Indication> indications;
	private Date date;

	public Long getId() {
		return id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public List<Drug> getDrugs() {
		return drugs;
	}

	public List<Indication> getIndications() {
		return indications;
	}

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
