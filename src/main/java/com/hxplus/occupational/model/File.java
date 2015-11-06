package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="file")
public class File{

	
	private Long id;
	private String fileName;
	private String type;
	private byte[] data;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId(){
		return id;
	}
	
	@Column(name="filename")
	public String getFileName() {
		return fileName;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}

	@Lob
	@Column(name="filedata")
	public byte[] getData() {
		return data;
	}
	
	public void setId(Long id){
		this.id = id;
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
