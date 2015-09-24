package com.hxplus.occupational.request;

import com.hxplus.occupational.model.History;


public class HabitRequest {

	private String name;
	private String frecuency;
	private History history;

	public String getName() {
		return name;
	}

	public String getFrecuency() {
		return frecuency;
	}

	public History getHistory() {
		return history;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}

	public void setHistory(History history) {
		this.history = history;
	}

}
