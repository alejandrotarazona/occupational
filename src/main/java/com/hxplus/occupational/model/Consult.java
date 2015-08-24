package com.hxplus.occupational.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.varia.FallbackErrorHandler;

@Entity
@Table(name = "consult")
public class Consult {

	private Long id;
	private Date consultDate;
	private Doctor doctor;
	private Prescription prescription;
	private List<Instruction> instructions;
	private List<VitalSign> vitalSigns;
	private SoapNote soapNote;
	private List<File> files;
	private List<Diagnostic> diagnostics;
	private List<Exam> requestExams;
	private List<Exam> recieveExams;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "consultdate")
	public Date getConsultDate() {
		return consultDate;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	public Doctor getDoctor() {
		return doctor;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	public Prescription getPrescription() {
		return prescription;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="consult")
	public List<Instruction> getInstructions() {
		return instructions;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="consult")
	public List<VitalSign> getVitalSigns() {
		return vitalSigns;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsoapnote", referencedColumnName="id")
	public SoapNote getSoapNote() {
		return soapNote;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="consult")
	public List<File> getFiles() {
		return files;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="consult")
	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="ordered")
	public List<Exam> getRequestExams() {
		return requestExams;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recieve_exam", 
	joinColumns = { @JoinColumn(name = "idconsult", nullable = false, updatable = false,referencedColumnName="id") }, 
	inverseJoinColumns = { @JoinColumn(name = "idexam", nullable = false, updatable = false, referencedColumnName= "id")}
	)
	public List<Exam> getRecieveExams() {
		return recieveExams;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public void setVitalSigns(List<VitalSign> vitalSigns) {
		this.vitalSigns = vitalSigns;
	}

	public void setSoapNote(SoapNote soapNote) {
		this.soapNote = soapNote;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public void setDiagnostics(List<Diagnostic> diagnostics) {
		this.diagnostics = diagnostics;
	}

	public void setRequestExams(List<Exam> requestExams) {
		this.requestExams = requestExams;
	}

	public void setRecieveExams(List<Exam> recieveExams) {
		this.recieveExams = recieveExams;
	}

}
