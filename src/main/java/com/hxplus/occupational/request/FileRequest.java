package com.hxplus.occupational.request;


public class FileRequest {

	private String fileName;
	private String type;
	private byte[] data;

	public String getFileName() {
		return fileName;
	}

	public String getType() {
		return type;
	}

	public byte[] getData() {
		return data;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
