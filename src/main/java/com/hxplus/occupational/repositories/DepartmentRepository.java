package com.hxplus.occupational.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.model.Department;

public interface DepartmentRepository  extends JpaRepository<Department, Long>{
	
	@Query("select d from Department d where d.company = (:company)")
	public List<Department> findByCompany(@Param("company") Company company);
}
