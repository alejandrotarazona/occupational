package com.hxplus.occupational.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Prescription;
import com.hxplus.occupational.repositories.PrescriptionRepository;
import com.hxplus.occupational.request.PrescriptionRequest;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	PrescriptionRepository prescriptionRepository;
	@Autowired
	IndicationService indicationService;

	@Override
	public Prescription findById(Long id) {
		return prescriptionRepository.findOne(id);
	}

	@Override
	public List<Prescription> findAll() {
		return prescriptionRepository.findAll();
	}
	
	@Override
	public List<Prescription> findByConsultId(Long idConsult) {
		return prescriptionRepository.findByConsultId(idConsult);
	}

	@Override
	public Prescription savePrescription(PrescriptionRequest prescriptionRequest) {
		Prescription prescription = prescriptionRepository.save(fromReq(
				new Prescription(), prescriptionRequest));
		prescription.setIndication(indicationService
				.saveIndication(prescriptionRequest.getIndication()));

		return null;
	}

	@Override
	public Prescription updatePrescription(Long id,
			PrescriptionRequest prescriptionRequest) {
		return prescriptionRepository.save(fromReq(findById(id),
				prescriptionRequest));
	}

	@Override
	public ResponseEntity<Object> deletePrescription(Long id) {
		try {
			prescriptionRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Prescription fromReq(Prescription prescription,
			PrescriptionRequest prescriptionRequest) {
		prescription.setDate(new Date());
		prescription.setDoctor(prescriptionRequest.getDoctor());
		prescription.setDrug(prescriptionRequest.getDrug());
		return prescription;
	}
}
