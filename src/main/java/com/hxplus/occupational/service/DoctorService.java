package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.request.DoctorRequest;

public interface DoctorService {
	public Doctor findById(Long id);
	public Doctor findByIdAndFetchPatientsEagerly(Long id);
	public List<Doctor> findAll();
	public Doctor saveDoctor(DoctorRequest doctorRequest);
	public Doctor updateDoctor(Long id, DoctorRequest doctorRequest);
	public ResponseEntity<Object> deleteDoctor(Long id);

}
