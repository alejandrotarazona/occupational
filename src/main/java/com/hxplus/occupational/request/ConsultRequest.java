package com.hxplus.occupational.request;

import java.util.Date;
import java.util.List;

import com.hxplus.occupational.model.Diagnostic;
import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.Exam;
import com.hxplus.occupational.model.File;
import com.hxplus.occupational.model.Instruction;
import com.hxplus.occupational.model.Prescription;
import com.hxplus.occupational.model.SoapNote;
import com.hxplus.occupational.model.VitalSign;

public class ConsultRequest {

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

	public Long getId() {
		return id;
	}

	public Date getConsultDate() {
		return consultDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public List<VitalSign> getVitalSigns() {
		return vitalSigns;
	}

	public SoapNote getSoapNote() {
		return soapNote;
	}

	public List<File> getFiles() {
		return files;
	}

	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	public List<Exam> getRequestExams() {
		return requestExams;
	}

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
