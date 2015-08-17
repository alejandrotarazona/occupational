package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allergy")
public class Allergy {

	private Long id;
	private String name;
	private String description;
	private String severity;

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

	@Column(name = "severity")
	public String getSeverity() {
		return severity;
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

	public void setSeverity(String severity) {
		this.severity = severity;
	}

}
