package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Contract;
import com.hxplus.occupational.request.ContractRequest;

public interface ContractService {
	
	public Contract findById(Long id);
	public List<Contract> findByUser(Long userId);
	public List<Contract> findAll();
	public Contract saveContract(ContractRequest contractRequest);
	public Contract updateContract(Long id, ContractRequest contractRequest);
	public ResponseEntity<Object> deleteContract(Long id);

}
