package com.hxplus.occupational.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "costcenter")
public class CostCenter {

	private Long id;
	private Company company;
	private String address;
	private String phoneNumber;
	private List<User> employees;
	private List<Post> posts;
	private List<Contract> contracts;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcompany", referencedColumnName = "id")
	@JsonBackReference
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

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "works")
	@JsonManagedReference
	public List<User> getEmployees() {
		return employees;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "havepost", 
		inverseJoinColumns = { @JoinColumn(name = "idpost", nullable = false, updatable = false, referencedColumnName = "id") }, 
		joinColumns = { @JoinColumn(name = "idcostcenter", nullable = false, updatable = false, referencedColumnName = "id") })
	public List<Post> getPosts() {
		return posts;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "costCenter")
	@JsonManagedReference
	public List<Contract> getContracts() {
		return contracts;
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
