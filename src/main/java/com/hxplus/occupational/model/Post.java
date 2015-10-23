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
@Table(name = "post")
public class Post {

	private Long id;
	private String name;
	private String description;
	private Department department;
	private List<CostCenter> costCenters;
	private List<Contract> contracts;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddepartment", referencedColumnName = "id")
	@JsonBackReference
	public Department getDepartment() {
		return department;
	}

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "havepost", 
		joinColumns = { @JoinColumn(name = "idpost", nullable = false, updatable = false,referencedColumnName="id") }, 
		inverseJoinColumns = { @JoinColumn(name = "idcostcenter", nullable = false, updatable = false, referencedColumnName= "id")})
	public List<CostCenter> getCostCenters() {
		return costCenters;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="post")
	@JsonManagedReference
	public List<Contract> getContracts() {
		return contracts;
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

	public void setCostCenters(List<CostCenter> costCenters) {
		this.costCenters = costCenters;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

}
