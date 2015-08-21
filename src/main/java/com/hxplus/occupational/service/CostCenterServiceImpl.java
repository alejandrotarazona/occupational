package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.CostCenter;
import com.hxplus.occupational.repositories.CostCenterRepository;
import com.hxplus.occupational.request.CostCenterRequest;

@Service
public class CostCenterServiceImpl implements CostCenterService {

	@Autowired
	CostCenterRepository costCenterRepository;

	@Override
	public CostCenter findById(Long id) {
		return costCenterRepository.findOne(id);
	}

	@Override
	public List<CostCenter> findAll() {
		return costCenterRepository.findAll();
	}

	@Override
	public CostCenter saveCostCenter(CostCenterRequest costCenterRequest) {
		return costCenterRepository.save(fromReq(new CostCenter(),
				costCenterRequest));
	}

	@Override
	public CostCenter updateCostCenter(Long id,
			CostCenterRequest costCenterRequest) {
		// TODO Auto-generated method stub
		return costCenterRepository.save(fromReq(findById(id),
				costCenterRequest));
	}

	@Override
	public ResponseEntity<Object> deleteCostCenter(Long id) {

		try {
			costCenterRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private CostCenter fromReq(CostCenter costCenter,
			CostCenterRequest costCenterRequest) {
		costCenter.setAddress(costCenterRequest.getAddress());
		costCenter.setPhoneNumber(costCenterRequest.getPhoneNumber());
		costCenter.setCompany(costCenterRequest.getCompany());
		costCenter.setEmployees(costCenterRequest.getEmployees());
		return costCenter;
	}

}
