package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.request.PatientRequest;

public interface PatientService {
	
	public Patient findById(Long id);
	public List<Patient> findAll();
	public Patient savePatient(PatientRequest patientRequest);
	public Patient updatePatient(Long id, PatientRequest patientRequest);
	public ResponseEntity<Object> deletePatient(Long id);

}
