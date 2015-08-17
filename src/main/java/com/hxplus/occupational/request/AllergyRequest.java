package com.hxplus.occupational.request;

public class AllergyRequest {

	private Long id;
	private String name;
	private String description;
	private String severity;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
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
