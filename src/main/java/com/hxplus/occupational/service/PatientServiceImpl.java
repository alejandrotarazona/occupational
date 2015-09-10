package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Patient;
import com.hxplus.occupational.repositories.PatientRepository;
import com.hxplus.occupational.request.PatientRequest;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient findById(Long id) {
		return patientRepository.findOne(id);
	}

	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	@Override
	public List<Patient> listByDoctor(Long iddoctor) {
//		List<Patient> patients = 
//		System.out.println("Id del Doctor: "+ iddoctor);
//		System.out.println("Lista de Pacientes: ");
//		for(Patient patient : patients){
//			System.out.println("\tPaciente: " + patient.getUser().getUsername());
//		}
		
		return patientRepository.listPatientsByDoctor(iddoctor);
	}

	@Override
	public Patient savePatient(PatientRequest patientRequest) {
		System.out.println("Guardando un Paciente");
		return patientRepository.save(fromReq(new Patient(), patientRequest));
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
		patient.setUser(patientRequest.getUser());
		patient.setHistory(patientRequest.getHistory());
		patient.setDoctors(patientRequest.getDoctors());
		return patient;
	}

}
