package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Company;

public class DepartmentRequest {

	private Long id;
	private String name;
	private String description;
	private Company company;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Company getCompany() {
		return company;
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

	public void setCompany(Company company) {
		this.company = company;
	}

}
