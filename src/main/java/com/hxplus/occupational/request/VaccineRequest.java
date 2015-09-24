package com.hxplus.occupational.request;

import com.hxplus.occupational.model.History;


public class VaccineRequest {

	private String name;
	private String potency;
	private History history;

	public String getName() {
		return name;
	}

	public String getPotency() {
		return potency;
	}

	public History getHistory() {
		return history;
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
