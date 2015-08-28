package com.hxplus.occupational.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vitalsigns")
public class VitalSign implements Serializable {

	private Consult consult;
	private String name;
	private String descripion;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idconsult", referencedColumnName = "id")
	public Consult getConsult() {
		return consult;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "description")
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
