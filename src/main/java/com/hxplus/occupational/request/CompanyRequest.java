package com.hxplus.occupational.request;


public class CompanyRequest {

	private Long id;
	private String companyName;
	private String rif;
	private String description;
	private CostCenterRequest mainLocation;
	
	public Long getId() {
		return id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getRif() {
		return rif;
	}
	public String getDescription() {
		return description;
	}
	public CostCenterRequest getMainLocation() {
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
	public void setMainLocation(CostCenterRequest mainLocation) {
		this.mainLocation = mainLocation;
	}

}
