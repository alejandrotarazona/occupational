package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Drug;
import com.hxplus.occupational.request.DrugRequest;

public interface DrugService {

	public Drug findById(Long id);
	public List<Drug> findAll();
	public Drug saveDrug(DrugRequest drugRequest);
	public Drug updateDrug(Long id, DrugRequest drugRequest);
	public ResponseEntity<Object> deleteDrug(Long id);
}
