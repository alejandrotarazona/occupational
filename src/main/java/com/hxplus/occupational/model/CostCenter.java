package com.hxplus.occupational.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "costcenter")
public class CostCenter {

	private Long id;
	private Company company;
	private String address;
	private String phoneNumber;
	private ArrayList<User> employees;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	public Company getCompany() {
		return company;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	@Column(name = "phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
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
