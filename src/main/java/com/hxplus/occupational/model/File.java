package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class File {

	private Consult consult;
	private String fileName;
	private java.io.File file;

	@OneToOne(fetch=FetchType.LAZY)
	@Column(name="id")
	public Consult getConsult() {
		return consult;
	}

	@Column(name="filename")
	public String getFileName() {
		return fileName;
	}

	@Column(name="file")
	public java.io.File getFile() {
		return file;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFile(java.io.File file) {
		this.file = file;
	}

}
