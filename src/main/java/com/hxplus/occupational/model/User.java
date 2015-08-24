package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {

	private Long id;
	private String username;
	private String password;
	private Long ci;
	private Long rif;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private CostCenter works;
	private Company employer;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	@Column(name = "ci")
	public Long getCi() {
		return ci;
	}

	@Column(name = "rif")
	public Long getRif() {
		return rif;
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	@Column(name = "phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcostcenter", referencedColumnName = "id")
	public CostCenter getWorks() {
		return works;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "idcompany", referencedColumnName = "id")
	public Company getEmployer() {
		return employer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCi(Long ci) {
		this.ci = ci;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRif(Long rif) {
		this.rif = rif;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWorks(CostCenter works) {
		this.works = works;
	}

	public void setEmployer(Company employer) {
		this.employer = employer;
	}

}
