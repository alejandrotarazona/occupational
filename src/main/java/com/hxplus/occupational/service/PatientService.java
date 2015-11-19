package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.request.PatientRequest;

public interface PatientService {
	
	public Patient findById(Long id);
	public List<Patient> findAll();
	public Patient findByConsultId(Long idConsult);
	public List<Patient> listByDoctor(Long id);
	public Patient savePatient(Long idUser, Long idDoctor, PatientRequest patientRequest);
	public Patient updatePatient(Long id, PatientRequest patientRequest);
	public ResponseEntity<Object> deletePatient(Long id);

}
