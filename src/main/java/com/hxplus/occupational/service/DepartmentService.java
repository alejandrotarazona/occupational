package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hxplus.occupational.model.Department;
import com.hxplus.occupational.request.DepartmentRequest;

public interface DepartmentService {

	public Department findById(Long id);
	public List<Department> findAll();
	public Department saveDepartment(DepartmentRequest departmentRequest);
	public Department createDepartment(Department department);
	public Department updateDepartment(Long id, DepartmentRequest departmentRequest);
	public ResponseEntity<Object> deleteDepartment(Long id);
}
