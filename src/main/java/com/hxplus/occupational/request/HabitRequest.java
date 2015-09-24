package com.hxplus.occupational.request;


public class HabitRequest {

	private String name;
	private String frecuency;
	private HistoryRequest history;

	public String getName() {
		return name;
	}

	public String getFrecuency() {
		return frecuency;
	}

	public HistoryRequest getHistory() {
		return history;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}

	public void setHistory(HistoryRequest history) {
		this.history = history;
	}

}
