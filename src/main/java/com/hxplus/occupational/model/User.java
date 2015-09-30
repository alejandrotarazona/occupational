package com.hxplus.occupational.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 727003876867333544L;
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
	private Post post;
	private List<Contract> contracts;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcostcenter", referencedColumnName = "id")
	public CostCenter getWorks() {
		return works;
	}
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcompany", referencedColumnName = "id")
	@JsonBackReference
	public Company getEmployer() {
		return employer;
	}
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idpost", referencedColumnName = "id")
	public Post getPost(){
		return post;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
	@JsonManagedReference
	public List<Contract> getContracts() {
		return contracts;
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
	
	public void setPost(Post post){
		this.post = post;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	
	public String toString(){
		return "Id: "+id+"\n\tUsername: "+ username;
	}

}
