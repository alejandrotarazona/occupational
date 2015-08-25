package com.hxplus.occupational.request;

import java.util.List;

import com.hxplus.occupational.model.Contract;
import com.hxplus.occupational.model.CostCenter;
import com.hxplus.occupational.model.Department;

public class PostRequest {

	private String name;
	private String description;
	private Department department;
	private CostCenter costCenter;
	private List<Contract> contracts;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Department getDepartment() {
		return department;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public List<Contract> getContracts() {
		return contracts;
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

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

}
