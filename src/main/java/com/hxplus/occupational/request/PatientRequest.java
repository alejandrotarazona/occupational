package com.hxplus.occupational.request;

import com.hxplus.occupational.model.History;

public class PatientRequest extends UserRequest {
	
	private History history;

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	
}
