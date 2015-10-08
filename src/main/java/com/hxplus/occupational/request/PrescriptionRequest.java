package com.hxplus.occupational.request;

import java.util.Date;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.Drug;
import com.hxplus.occupational.model.Indication;

public class PrescriptionRequest {

	private Doctor doctor;
	private Drug drug;
	private IndicationRequest indication;
	private Date date;
	private Consult consult;

	public Doctor getDoctor() {
		return doctor;
	}

	public Drug getDrug() {
		return drug;
	}

	public IndicationRequest getIndication() {
		return indication;
	}

	public Date getDate() {
		return date;
	}

	public Consult getConsult() {
		return consult;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public void setIndication(IndicationRequest indication) {
		this.indication = indication;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

}
