package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.repositories.CompanyRepository;
import com.hxplus.occupational.request.CompanyRequest;

public class CompanyServiceImpl implements CompanyService {
	
	@Autowired CompanyRepository companyRepository;

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
		return companyRepository.save(fromReq(new Company(), companyRequest));
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
		try{
			companyRepository.delete(id);
			return new ResponseEntity<Object>(null,HttpStatus.OK);
		} catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Company fromReq(Company company, CompanyRequest companyRequest){
		company.setCompanyName(companyRequest.getCompanyName());
		company.setDescription(companyRequest.getDescription());
		company.setRif(companyRequest.getRif());
		company.setMainLocation(companyRequest.getMainLocation());
		return company;
	}
}
