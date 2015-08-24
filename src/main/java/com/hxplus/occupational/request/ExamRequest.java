package com.hxplus.occupational.request;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.model.Diagnostic;

public class ExamRequest {
	private Date orderedAt;
	private Consult ordered;
	private Date receivedAt;
	private List<Consult> received;
	private String type;
	private File results;
	private List<Diagnostic> diagnostics;

	public Date getOrderedAt() {
		return orderedAt;
	}

	public Consult getOrdered() {
		return ordered;
	}

	public Date getReceivedAt() {
		return receivedAt;
	}

	public List<Consult> getReceived() {
		return received;
	}

	public String getType() {
		return type;
	}

	public File getResults() {
		return results;
	}

	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	public void setOrderedAt(Date orderedAt) {
		this.orderedAt = orderedAt;
	}

	public void setOrdered(Consult ordered) {
		this.ordered = ordered;
	}

	public void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}

	public void setReceived(List<Consult> received) {
		this.received = received;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setResults(File results) {
		this.results = results;
	}

	public void setDiagnostics(List<Diagnostic> diagnostics) {
		this.diagnostics = diagnostics;
	}

}
