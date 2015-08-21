package com.hxplus.occupational.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends BaseEntity {

	private Long id;
	private String companyName;
	private String rif;
	private String description;
	private CostCenter mainLocation;
	private List<Department> departments;
	private List<User> employees;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "companyname")
	public String getCompanyName() {
		return companyName;
	}

	@Column(name = "rif")
	public String getRif() {
		return rif;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	@OneToOne
	@JoinColumn(name = "idcostcenter", referencedColumnName = "id")
	public CostCenter getMainLocation() {
		return mainLocation;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName="idcompany")
	public List<Department> getDepartments() {
		return departments;
	}
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "idcompany")
	public List<User> getEmployees() {
		return employees;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMainLocation(CostCenter mainLocation) {
		this.mainLocation = mainLocation;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

}
