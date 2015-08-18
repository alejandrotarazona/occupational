package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class Diagnostic {

	private Consult consult;
	private String details;

	@OneToOne(fetch=FetchType.LAZY)
	@Column(name="id")
	public Consult getConsult() {
		return consult;
	}

	@Column(name="details")
	public String getDetails() {
		return details;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
