package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Department;

public class PostRequest {

	private Long id;
	private String name;
	private String description;
	private Department department;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Department getDepartment() {
		return department;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
