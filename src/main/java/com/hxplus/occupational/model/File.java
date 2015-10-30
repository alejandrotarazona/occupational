package com.hxplus.occupational.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="file")
public class File implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8349015290213828971L;
	private Long id;
	private Consult consult;
	private String fileName;
	private String type;
	private java.io.File file;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId(){
		return id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idconsult",referencedColumnName="id")
	public Consult getConsult() {
		return consult;
	}

	@Column(name="filename")
	public String getFileName() {
		return fileName;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}

	@Column(name="filedata")
	public java.io.File getFile() {
		return file;
	}
	
	public void setId(Long id){
		this.id = id;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setFile(java.io.File file) {
		this.file = file;
	}

}
