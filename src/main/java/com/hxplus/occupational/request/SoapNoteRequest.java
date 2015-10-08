package com.hxplus.occupational.request;

public class SoapNoteRequest {

	private Long id;
	private ConsultRequest consultRequest;
	private String subjective, objective, plan, comments;
	private DiagnosticRequest diagnosticRequest;

	public Long getId() {
		return id;
	}

	public ConsultRequest getConsultRequest() {
		return consultRequest;
	}

	public String getSubjective() {
		return subjective;
	}

	public String getObjective() {
		return objective;
	}

	public String getPlan() {
		return plan;
	}

	public String getComments() {
		return comments;
	}

	public DiagnosticRequest getDiagnosticRequest() {
		return diagnosticRequest;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setConsultRequest(ConsultRequest consultRequest) {
		this.consultRequest = consultRequest;
	}

	public void setSubjective(String subjective) {
		this.subjective = subjective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setDiagnosticRequest(DiagnosticRequest diagnosticRequest) {
		this.diagnosticRequest = diagnosticRequest;
	}

}
