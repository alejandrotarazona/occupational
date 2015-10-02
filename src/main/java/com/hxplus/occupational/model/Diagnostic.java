package com.hxplus.occupational.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.property.Getter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "diagnostic")
public class Diagnostic implements Serializable {

	private Long id;
	private Consult consult;
	private String details;
	private List<Instruction> instructions;
	private Exam exam;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idconsult", referencedColumnName = "id")
	public Consult getConsult() {
		return consult;
	}

	@Column(name = "details")
	public String getDetails() {
		return details;
	}

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "have_inst", joinColumns = @JoinColumn(name = "iddiagnstic", referencedColumnName = "idconsult"), inverseJoinColumns = @JoinColumn(name = "idinstruction", referencedColumnName = "id"))
	public List<Instruction> getInstructions() {
		return instructions;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idexam", referencedColumnName = "id")
	public Exam getExam() {
		return exam;
	}

	public void setId(Long id) {
		this.id = id;
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
