package com.hxplus.occupational.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Doctor;
import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.repositories.PatientRepository;
import com.hxplus.occupational.repositories.UserRepository;
import com.hxplus.occupational.request.PatientRequest;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	DoctorService doctorService;

	@Override
	public Patient findById(Long id) {
		return patientRepository.findOne(id);
	}

	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	@Override
	public Patient findByConsultId(Long idConsult) {
		return patientRepository.findByConsultId(idConsult);
	}

	@Override
	public List<Patient> listByDoctor(Long iddoctor) {
		return patientRepository.listPatientsByDoctor(iddoctor);
	}

	@Override
	public Patient savePatient(Long idUser, Long idDoctor,
			PatientRequest patientRequest) {

		Patient patient = fromReq(new Patient(), patientRequest); 

		patient.setUser(userRepository.findOne(idUser));

		Doctor doctor = doctorService.findByUserId(idDoctor);
		List<Doctor> doctors = new ArrayList<>();
		doctors.add(doctor);

		patient.setDoctors(doctors);

		patientRepository.saveAndFlush(patient); // Guarda un nuevo paciente

		return patient;
	}

	@Override
	public Patient updatePatient(Long id, PatientRequest patientRequest) {
		return patientRepository.save(fromReq(findById(id), patientRequest));
	}

	@Override
	public ResponseEntity<Object> deletePatient(Long id) {
		try {
			patientRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Patient fromReq(Patient patient, PatientRequest patientRequest) {

		System.out.println("FromReq Terminado");
		return patient;
	}

}
