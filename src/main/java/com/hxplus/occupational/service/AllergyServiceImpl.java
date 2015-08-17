package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Allergy;
import com.hxplus.occupational.repositories.AllergyRepository;
import com.hxplus.occupational.request.AllergyRequest;

public class AllergyServiceImpl implements AllergyService {
	
	@Autowired AllergyRepository allergyRepository;

	@Override
	public Allergy findById(Long id) {
		return allergyRepository.findOne(id);
	}

	@Override
	public List<Allergy> findAll() {
		return allergyRepository.findAll();
	}

	@Override
	public Allergy saveAllergy(AllergyRequest allergyRequest) {
		return allergyRepository.save(fromReq(new Allergy(), allergyRequest));
	}

	@Override
	public Allergy updateAllergy(Long id, AllergyRequest allergyRequest) {
		return allergyRepository.save(fromReq(findById(id), allergyRequest));
	}

	@Override
	public ResponseEntity<Object> deleteAllergy(Long id) {
		try{
			allergyRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Allergy fromReq(Allergy allergy, AllergyRequest allergyRequest){
		allergy.setName(allergyRequest.getName());
		allergy.setDescription(allergyRequest.getDescription());
		allergy.setSeverity(allergyRequest.getSeverity());
		return allergy;
	}

}
