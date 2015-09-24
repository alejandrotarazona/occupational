package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vaccine")
public class Vaccine {

	private Long id;
	private String name;
	private String potency;
	private History history;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "potency")
	public String getPotency() {
		return potency;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idhistory", referencedColumnName = "id")
	public History getHistory() {
		return history;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPotency(String potency) {
		this.potency = potency;
	}

	public void setHistory(History history) {
		this.history = history;
	}
}
