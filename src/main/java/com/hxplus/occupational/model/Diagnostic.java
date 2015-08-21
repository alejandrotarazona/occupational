package com.hxplus.occupational.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="diagnostic")
public class Diagnostic implements Serializable {

	private Consult consult;
	private String details;

	@Id
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
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
