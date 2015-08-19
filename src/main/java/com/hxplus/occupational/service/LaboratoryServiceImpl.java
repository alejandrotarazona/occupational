package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Laboratory;
import com.hxplus.occupational.repositories.LaboratoryRepository;
import com.hxplus.occupational.request.LaboratoryRequest;

public class LaboratoryServiceImpl implements LaboratoryService {

	@Autowired
	LaboratoryRepository laboratoryRepository;

	@Override
	public Laboratory findById(Long id) {
		return laboratoryRepository.findOne(id);
	}

	@Override
	public List<Laboratory> findAll() {
		return laboratoryRepository.findAll();
	}

	@Override
	public Laboratory saveLaboratory(LaboratoryRequest laboratoryRequest) {
		return laboratoryRepository.save(fromReq(new Laboratory(),
				laboratoryRequest));
	}

	@Override
	public Laboratory updateLaboratory(Long id,
			LaboratoryRequest laboratoryRequest) {
		return laboratoryRepository.save(fromReq(findById(id),
				laboratoryRequest));
	}

	@Override
	public ResponseEntity<Object> deleteLaboratory(Long id) {
		try {
			laboratoryRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Laboratory fromReq(Laboratory laboratory,
			LaboratoryRequest laboratoryRequest) {
		laboratory.setName(laboratoryRequest.getName());
		laboratory.setPhoneNumber(laboratoryRequest.getPhoneNumber());
		return laboratory;
	}

}
