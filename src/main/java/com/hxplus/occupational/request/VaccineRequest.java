package com.hxplus.occupational.request;


public class VaccineRequest {

	private String name;
	private String potency;
	private HistoryRequest history;

	public String getName() {
		return name;
	}

	public String getPotency() {
		return potency;
	}

	public HistoryRequest getHistory() {
		return history;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPotency(String potency) {
		this.potency = potency;
	}

	public void setHistory(HistoryRequest history) {
		this.history = history;
	}

}
