package com.hxplus.occupational.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="file")
public class File implements Serializable{

	private Consult consult;
	private String fileName;
	private java.io.File file;

	@Id
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id")
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
