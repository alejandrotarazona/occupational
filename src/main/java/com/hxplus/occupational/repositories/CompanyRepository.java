package com.hxplus.occupational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hxplus.occupational.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
