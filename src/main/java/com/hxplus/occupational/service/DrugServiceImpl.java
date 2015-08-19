package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Drug;
import com.hxplus.occupational.repositories.DrugRepository;
import com.hxplus.occupational.request.DrugRequest;

public class DrugServiceImpl implements DrugService {

	@Autowired
	DrugRepository drugRepository;

	@Override
	public Drug findById(Long id) {
		return drugRepository.findOne(id);
	}

	@Override
	public List<Drug> findAll() {
		return drugRepository.findAll();
	}

	@Override
	public Drug saveDrug(DrugRequest drugRequest) {
		return drugRepository.save(fromReq(new Drug(), drugRequest));
	}

	@Override
	public Drug updateDrug(Long id, DrugRequest drugRequest) {
		return drugRepository.save(fromReq(findById(id), drugRequest));
	}

	@Override
	public ResponseEntity<Object> deleteDrug(Long id) {
		try {
			drugRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Drug fromReq(Drug drug, DrugRequest drugRequest) {
		drug.setName(drugRequest.getName());
		drug.setDescription(drugRequest.getDescription());
		drug.setLaboratory(drugRequest.getLaboratory());
		return drug;
	}

}
