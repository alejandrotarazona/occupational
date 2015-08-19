package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Laboratory;
import com.hxplus.occupational.request.LaboratoryRequest;

public interface LaboratoryService {
	
	public Laboratory findById(Long id);
	public List<Laboratory> findAll();
	public Laboratory saveLaboratory(LaboratoryRequest laboratoryRequest);
	public Laboratory updateLaboratory(Long id, LaboratoryRequest laboratoryRequest);
	public ResponseEntity<Object> deleteLaboratory(Long id);

}
