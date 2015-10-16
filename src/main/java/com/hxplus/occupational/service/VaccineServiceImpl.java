package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Vaccine;
import com.hxplus.occupational.repositories.VaccineRepository;
import com.hxplus.occupational.request.VaccineRequest;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	VaccineRepository vaccineRepository;

	@Override
	public Vaccine findById(Long id) {
		return vaccineRepository.findOne(id);
	}

	@Override
	public List<Vaccine> findAll() {
		return vaccineRepository.findAll();
	}

	@Override
	public List<Vaccine> findByPatientId(Long idPatient) {
		return vaccineRepository.findByPatientId(idPatient);
	}

	@Override
	public Vaccine saveVaccine(VaccineRequest vaccineRequest) {
		return vaccineRepository.saveAndFlush(fromReq(new Vaccine(),
				vaccineRequest));
	}

	@Override
	public Vaccine updateVaccine(Long id, VaccineRequest vaccineRequest) {
		return vaccineRepository.save(fromReq(findById(id), vaccineRequest));
	}

	@Override
	public ResponseEntity<Object> deleteVaccine(Long id) {
		try {
			vaccineRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Vaccine fromReq(Vaccine vaccine, VaccineRequest vaccineRequest) {
		vaccine.setName(vaccineRequest.getName());
		vaccine.setPotency(vaccineRequest.getPotency());
		vaccine.setPatient(vaccineRequest.getPatient());
		return vaccine;
	}

}
