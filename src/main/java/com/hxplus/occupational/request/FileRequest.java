package com.hxplus.occupational.request;

import java.io.File;

import com.hxplus.occupational.model.Consult;

public class FileRequest {

	private Consult consult;
	private String fileName;
	private File file;

	public Consult getConsult() {
		return consult;
	}

	public String getFileName() {
		return fileName;
	}

	public File getFile() {
		return file;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
