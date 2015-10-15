package com.hxplus.occupational.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "soapnote")
public class SoapNote {

	private Long id;
	private Consult consult;
	private String subjective, objective, plan, comments;
	private Diagnostic diagnostic;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "soapNote")
	public Consult getConsult() {
		return consult;
	}

	@Column(name = "subjective")
	public String getSubjective() {
		return subjective;
	}

	@Column(name = "objective")
	public String getObjective() {
		return objective;
	}

	@Column(name = "plan")
	public String getPlan() {
		return plan;
	}

	@Column(name = "comments")
	public String getComments() {
		return comments;
	}
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddiagnostic", referencedColumnName = "id")
	public Diagnostic getDiagnostic() {
		return diagnostic;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
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

	public void setDiagnostic(Diagnostic diagnostic) {
		this.diagnostic = diagnostic;
	}

}
