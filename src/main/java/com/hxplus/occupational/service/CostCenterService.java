package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.CostCenter;
import com.hxplus.occupational.request.CostCenterRequest;

public interface CostCenterService {

	public CostCenter findById(Long id);
	public List<CostCenter> findAll();
	public CostCenter findByUserId(Long userId);
	public CostCenter saveCostCenter(CostCenterRequest costCenterRequest);
	public CostCenter updateCostCenter(Long id, CostCenterRequest costCenterRequest);
	public ResponseEntity<Object> deleteCostCenter(Long id);
}
