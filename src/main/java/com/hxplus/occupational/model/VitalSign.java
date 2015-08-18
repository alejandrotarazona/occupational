package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class VitalSign {

	private Consult consult;
	private String name;
	private String descripion;

	@OneToOne(fetch=FetchType.LAZY)
	@Column(name="id")
	public Consult getConsult() {
		return consult;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	@Column(name="description")
	public String getDescripion() {
		return descripion;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

}
