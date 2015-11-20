package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Consult;

public class PDFRequest {

	String[] toPrint;
	Consult consult;
	int restDays;

	public String[] getToPrint() {
		return toPrint;
	}

	public Consult getConsult() {
		return consult;
	}

	public int getRestDays() {
		return restDays;
	}

	public void setToPrint(String[] toPrint) {
		this.toPrint = toPrint;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setRestDays(int restDays) {
		this.restDays = restDays;
	}

}
