package com.hxplus.occupational.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.property.Getter;

@Entity
@Table(name = "diagnostic")
public class Diagnostic implements Serializable {

	private Consult consult;
	private String details;
	private List<Instruction> instructions;
	private Exam exam;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idconsult", referencedColumnName = "id")
	public Consult getConsult() {
		return consult;
	}

	@Column(name = "details")
	public String getDetails() {
		return details;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "diagnostic")
	public List<Instruction> getInstructions() {
		return instructions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idexam", referencedColumnName = "id")
	public Exam getExam() {
		return exam;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
