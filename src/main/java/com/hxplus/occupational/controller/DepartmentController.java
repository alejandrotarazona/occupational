package com.hxplus.occupational.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxplus.occupational.model.Department;
import com.hxplus.occupational.request.DepartmentRequest;
import com.hxplus.occupational.service.DepartmentService;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Department getDepartment(@PathVariable("id") Long id) {
		return departmentService.findById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody
	List<Department> getDepartments() {
		return departmentService.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public @ResponseBody
	Department createDepartment(@RequestBody DepartmentRequest departmentRequest) {
		return departmentService.saveDepartment(departmentRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Department updateDepartment(@PathVariable Long id,
			@RequestBody DepartmentRequest departmentRequest) {
		return departmentService.updateDepartment(id, departmentRequest);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<Object> deleteDepartment(@PathVariable("id") Long id) {
		return departmentService.deleteDepartment(id);
	}
}
