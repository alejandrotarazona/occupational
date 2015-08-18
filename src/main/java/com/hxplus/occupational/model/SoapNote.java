package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class SoapNote {

	private Consult consult;
	private String description;

	@OneToOne(fetch=FetchType.LAZY)
	@Column(name="id")
	public Consult getConsult() {
		return consult;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
