package com.hxplus.occupational.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "costcenter")
public class CostCenter {

	private Long id;
	private Company company;
	private String address;
	private String phoneNumber;
	private List<User> employees;
	private List<Post> posts;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcompany	", referencedColumnName = "id")
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

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user")
	@JoinColumn(table = "user" ,referencedColumnName = "id")
	public List<User> getEmployees() {
		return employees;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name="post")
	@JoinColumn(referencedColumnName="idcostcenter")
	public List<Post> getPosts() {
		return posts;
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

}
