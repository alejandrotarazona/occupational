package com.hxplus.occupational.request;


public class AllergyRequest {

	private String name;
	private String description;
	private String severity;
	private HistoryRequest history;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getSeverity() {
		return severity;
	}

	public HistoryRequest getHistory() {
		return history;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public void setHistory(HistoryRequest history) {
		this.history = history;
	}

}
