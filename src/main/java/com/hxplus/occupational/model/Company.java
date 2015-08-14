package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends BaseEntity {

	private Long id;
	private String companyName;
	private String rif;
	private String description;
	private String mainLocation;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name="companyName")
	public String getCompanyName() {
		return companyName;
	}

	@Column(name="rif")
	public String getRif() {
		return rif;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}
	
	@OneToOne
	@JoinColumn(name="id")
	public String getMainLocation() {
		return mainLocation;
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

	public void setMainLocation(String mainLocation) {
		this.mainLocation = mainLocation;
	}
	
	

}
