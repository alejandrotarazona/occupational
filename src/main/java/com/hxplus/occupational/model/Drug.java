package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "drug")
public class Drug {

	private Long id;
	private String name;
	private Laboratory laboratory;
	private String description;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id")
	public Laboratory getLaboratory() {
		return laboratory;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
