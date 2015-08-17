package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Allergy;
import com.hxplus.occupational.request.AllergyRequest;;

public interface AllergyService {

	public Allergy findById(Long id);
	public List<Allergy> findAll();
	public Allergy saveAllergy(AllergyRequest allergyRequest);
	public Allergy updateAllergy(Long id, AllergyRequest allergyRequest);
	public ResponseEntity<Object> deleteAllergy(Long id);
}
