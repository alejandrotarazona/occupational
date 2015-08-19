package com.hxplus.occupational.request;

import com.hxplus.occupational.model.Laboratory;

public class DrugRequest {

	private Long id;
	private String name;
	private Laboratory laboratory;
	private String description;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Laboratory getLaboratory() {
		return laboratory;
	}

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
