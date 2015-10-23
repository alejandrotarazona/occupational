package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Indication;
import com.hxplus.occupational.request.IndicationRequest;

public interface IndicationService {

	public Indication findById(Long id);
	public List<Indication> findAll();
	public Indication findByPrescription(Long idPrescription);
	public Indication saveIndication(IndicationRequest indicationRequest);
	public Indication updateIndication(Long id, IndicationRequest indicationRequest);
	public ResponseEntity<Object> deleteIndication(Long id);
}
