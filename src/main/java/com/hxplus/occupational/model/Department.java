package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {

	private Long id;
	private String name;
	private String description;
	private Company company;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public Company getCompany() {
		return company;
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

	public void setCompany(Company company) {
		this.company = company;
	}

}
