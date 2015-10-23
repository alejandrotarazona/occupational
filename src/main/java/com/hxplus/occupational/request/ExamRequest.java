package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Consult;

public class ExamRequest {

	private Consult ordered;
	private List<Consult> received;
	private String type;
	private FileRequest results;

	public Consult getOrdered() {
		return ordered;
	}

	public List<Consult> getReceived() {
		return received;
	}

	public String getType() {
		return type;
	}

	public FileRequest getResults() {
		return results;
	}

	public void setOrdered(Consult ordered) {
		this.ordered = ordered;
	}

	public void setReceived(List<Consult> received) {
		this.received = received;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setResults(FileRequest results) {
		this.results = results;
	}

}
