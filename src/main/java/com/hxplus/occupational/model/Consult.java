package com.hxplus.occupational.model;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "consult")
public class Consult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1047944888325521959L;
	private Long id;
	private Patient patient;
	private Date consultDate;
	private Doctor doctor;
	private List<Prescription> prescriptions;
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

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idpatient", referencedColumnName = "id")
	@JsonBackReference
	public Patient getPatient() {
		return patient;
	}

	@Column(name = "consultdate")
	public Date getConsultDate() {
		return consultDate;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "iddoctor", referencedColumnName = "id")
	@JsonBackReference
	public Doctor getDoctor() {
		return doctor;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "consult")
	@JsonManagedReference
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "consult")
	@JsonManagedReference
	public List<Instruction> getInstructions() {
		return instructions;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "consult")
	@JsonManagedReference
	public List<VitalSign> getVitalSigns() {
		return vitalSigns;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsoapnote", referencedColumnName = "id")
	public SoapNote getSoapNote() {
		return soapNote;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "consult")
	@JsonManagedReference
	public List<File> getFiles() {
		return files;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "consult")
	@JsonManagedReference
	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "ordered")
	@JsonManagedReference
	public List<Exam> getRequestExams() {
		return requestExams;
	}

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "recieve_exam", 
		joinColumns = { @JoinColumn(name = "idconsult", nullable = false, updatable = false, referencedColumnName = "id") }, 
		inverseJoinColumns = { @JoinColumn(name = "idexam", nullable = false, updatable = false, referencedColumnName = "id") })
	public List<Exam> getRecieveExams() {
		return recieveExams;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
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
