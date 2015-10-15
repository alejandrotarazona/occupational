package com.hxplus.occupational.request;

import java.util.Date;
import java.util.List;

import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.Exam;
import com.hxplus.occupational.model.Patient;

public class ConsultRequest {

	private Date consultDate;
	private Doctor doctor;
	private Patient patient;
	private List<PrescriptionRequest> prescriptions;
	private List<InstructionRequest> instructions;
	private List<VitalSignRequest> vitalSigns;
	private SoapNoteRequest soapNote;
	private List<FileRequest> files;
	private List<DiagnosticRequest> diagnostics;
	private List<ExamRequest> requestExams;
	private List<Exam> recieveExams;

	public Date getConsultDate() {
		return consultDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public List<PrescriptionRequest> getPrescriptions() {
		return prescriptions;
	}

	public List<InstructionRequest> getInstructions() {
		return instructions;
	}

	public List<VitalSignRequest> getVitalSigns() {
		return vitalSigns;
	}

	public SoapNoteRequest getSoapNote() {
		return soapNote;
	}

	public List<FileRequest> getFiles() {
		return files;
	}

	public List<DiagnosticRequest> getDiagnostics() {
		return diagnostics;
	}

	public List<ExamRequest> getRequestExams() {
		return requestExams;
	}

	public List<Exam> getRecieveExams() {
		return recieveExams;
	}

	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setPrescriptions(List<PrescriptionRequest> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public void setInstructions(List<InstructionRequest> instructions) {
		this.instructions = instructions;
	}

	public void setVitalSigns(List<VitalSignRequest> vitalSigns) {
		this.vitalSigns = vitalSigns;
	}

	public void setSoapNote(SoapNoteRequest soapNote) {
		this.soapNote = soapNote;
	}

	public void setFiles(List<FileRequest> files) {
		this.files = files;
	}

	public void setDiagnostics(List<DiagnosticRequest> diagnostics) {
		this.diagnostics = diagnostics;
	}

	public void setRequestExams(List<ExamRequest> requestExams) {
		this.requestExams = requestExams;
	}

	public void setRecieveExams(List<Exam> recieveExams) {
		this.recieveExams = recieveExams;
	}

}
