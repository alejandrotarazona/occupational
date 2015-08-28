package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Contract;
import com.hxplus.occupational.repositories.ContractRepository;
import com.hxplus.occupational.request.ContractRequest;

@Service
public class ContractServiceImpl implements ContractService {
	
	@Autowired ContractRepository contractRepository;

	@Override
	public Contract findById(Long id) {
		return contractRepository.findOne(id);
	}

	@Override
	public List<Contract> findAll() {
		return contractRepository.findAll();
	}

	@Override
	public Contract saveContract(ContractRequest contractRequest) {
		return contractRepository.save(fromReq(new Contract(), contractRequest));
	}

	@Override
	public Contract updateContract(Long id, ContractRequest contractRequest) {
		return contractRepository.save(fromReq(findById(id), contractRequest));
	}

	@Override
	public ResponseEntity<Object> deleteContract(Long id) {
		try{
			contractRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Contract fromReq(Contract contract, ContractRequest contractRequest){
		contract.setBeginDate(contractRequest.getBeginDate());
		contract.setEndDate(contractRequest.getEndDate());
		contract.setCostCenter(contractRequest.getCostCenter());
		contract.setPost(contractRequest.getPost());
		contract.setUser(contractRequest.getUser());
		
		return contract;
	}

	@Override
	public List<Contract> findByUser(Long userId) {
		return contractRepository.findByUser(userId);
	}

}