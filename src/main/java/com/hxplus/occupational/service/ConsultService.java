package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Consult;
import com.hxplus.occupational.request.ConsultRequest;

public interface ConsultService {

	public Consult findById(Long id);
	public List<Consult> findAll();
	public List<Consult> findAllByIdHistory(Long idHistory);
	public Consult saveConsult(ConsultRequest consultRequest);
	public Consult updateConsult(Long id, ConsultRequest consultRequest);
	public ResponseEntity<Object> deleteConsult(Long id);

}
