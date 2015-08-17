package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.request.CompanyRequest;

public interface CompanyService {
	
	public Company findById(Long id);
	public List<Company> findAll();
	public Company saveCompany(CompanyRequest companyRequest);
	public Company createCompany(Company companyRequest);
	public Company updateCompany(Long id, CompanyRequest companyRequest);
	public ResponseEntity<Object> deleteCompany(Long id);
	

}
