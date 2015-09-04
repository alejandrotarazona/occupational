package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.repositories.DoctorRepository;
import com.hxplus.occupational.request.DoctorRequest;
@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired DoctorRepository doctorRepository;

	@Override
	public Doctor findById(Long id) {
		return doctorRepository.findOne(id);
	}
	
	@Override
	public Doctor findByIdAndFetchPatientsEagerly(Long id){
		return doctorRepository.findByIdAndFetchPatientsEagerly(id);
	}

	@Override
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor saveDoctor(DoctorRequest doctorRequest) {
		return doctorRepository.save(fromReq(new Doctor(), doctorRequest));
	}

	@Override
	public Doctor updateDoctor(Long id, DoctorRequest doctorRequest) {
		return doctorRepository.save(fromReq(findById(id), doctorRequest));
	}

	@Override
	public ResponseEntity<Object> deleteDoctor(Long id) {
		try{
			doctorRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) { 
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Doctor fromReq(Doctor doctor, DoctorRequest doctorRequest){
		doctor.setUser(doctorRequest.getUser());
		doctor.setRegNumber(doctorRequest.getRegNumber());
		doctor.setPatients(doctorRequest.getPatients());
		doctor.setConsults(doctorRequest.getConsults());
		return doctor;
	}
}
