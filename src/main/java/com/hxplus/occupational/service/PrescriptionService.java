package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Prescription;
import com.hxplus.occupational.request.PrescriptionRequest;

public interface PrescriptionService {
	
	public Prescription findById(Long id);
	public List<Prescription> findAll();
	public Prescription savePrescription(PrescriptionRequest prescriptionRequest);
	public Prescription updatePrescription(Long id, PrescriptionRequest prescriptionRequest);
	public ResponseEntity<Object> deletePrescription(Long id);

}
