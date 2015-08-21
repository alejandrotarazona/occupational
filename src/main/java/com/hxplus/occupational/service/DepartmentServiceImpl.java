package com.hxplus.occupational.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hxplus.occupational.model.Department;
import com.hxplus.occupational.repositories.DepartmentRepository;
import com.hxplus.occupational.request.DepartmentRequest;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department findById(Long id) {
		return departmentRepository.findOne(id);
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department saveDepartment(DepartmentRequest departmentRequest) {
		return departmentRepository.save(fromReq(new Department(),
				departmentRequest));
	}

	@Override
	public Department createDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department updateDepartment(Long id,
			DepartmentRequest departmentRequest) {
		return departmentRepository.save(fromReq(findById(id),
				departmentRequest));
	}

	@Override
	public ResponseEntity<Object> deleteDepartment(Long id) {
		try {
			departmentRepository.delete(id);
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>(ex.getLocalizedMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private Department fromReq(Department department,
			DepartmentRequest departmentRequest) {
		department.setDescription(departmentRequest.getDescription());
		department.setName(departmentRequest.getName());
		department.setCompany(departmentRequest.getCompany());

		return department;
	}

}
