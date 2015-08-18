package com.hxplus.occupational.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
@PrimaryKeyJoinColumn(name = "id")
public class Patient extends User {

	private History history;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

}
