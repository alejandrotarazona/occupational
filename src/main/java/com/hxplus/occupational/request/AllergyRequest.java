package com.hxplus.occupational.request;

import com.hxplus.occupational.model.History;

public class AllergyRequest {

	private String name;
	private String description;
	private String severity;
	private History history;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getSeverity() {
		return severity;
	}

	public History getHistory() {
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

	public void setHistory(History history) {
		this.history = history;
	}

}
