package com.hxplus.occupational.request;

import java.util.ArrayList;

import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.model.User;

public class CostCenterRequest {

	private Long id;
	private Company company;
	private String address;
	private String phoneNumber;
	private ArrayList<User> employees;

	public Long getId() {
		return id;
	}

	public Company getCompany() {
		return company;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public ArrayList<User> getEmployees() {
		return employees;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmployees(ArrayList<User> employees) {
		this.employees = employees;
	}
}
