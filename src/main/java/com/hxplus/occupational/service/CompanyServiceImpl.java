package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.repositories.CompanyRepository;
import com.hxplus.occupational.request.CompanyRequest;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	CostCenterService costCenterService;

	@Override
	public Company findById(Long id) {
		return companyRepository.findOne(id);
	}

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public Company saveCompany(CompanyRequest companyRequest) {
		Company company =  companyRepository.save(fromReq(new Company(), companyRequest));
		company.setMainLocation(costCenterService.saveCostCenter(companyRequest.getMainLocation()));
		
		return company;
	}

	@Override
	public Company createCompany(Company companyRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company updateCompany(Long id, CompanyRequest companyRequest) {
		return companyRepository.save(fromReq(findById(id), companyRequest));
	}

	@Override
	public ResponseEntity<Object> deleteCompany(Long id) {
		try {
			companyRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Company fromReq(Company company, CompanyRequest companyRequest) {
		company.setCompanyName(companyRequest.getCompanyName());
		company.setDescription(companyRequest.getDescription());
		company.setRif(companyRequest.getRif());
		return company;
	}
}
