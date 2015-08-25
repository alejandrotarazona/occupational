package com.hxplus.occupational.request;

import java.util.ArrayList;
import java.util.List;

import com.hxplus.occupational.model.Company;
import com.hxplus.occupational.model.Contract;
import com.hxplus.occupational.model.Post;
import com.hxplus.occupational.model.User;

public class CostCenterRequest {

	private Company company;
	private String address;
	private String phoneNumber;
	private List<User> employees;
	private List<Post> posts;
	private List<Contract> contracts;

	public Company getCompany() {
		return company;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public List<User> getEmployees() {
		return employees;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public List<Contract> getContracts() {
		return contracts;
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

	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

}
