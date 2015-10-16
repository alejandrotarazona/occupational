package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Vaccine;
import com.hxplus.occupational.request.VaccineRequest;

public interface VaccineService {
	
	public Vaccine findById(Long id);
	public List<Vaccine> findAll();
	public List<Vaccine> findByPatientId(Long idPatient);
	public Vaccine saveVaccine(VaccineRequest vaccineRequest);
	public Vaccine updateVaccine(Long id, VaccineRequest vaccineRequest);
	public ResponseEntity<Object> deleteVaccine(Long id);

}
