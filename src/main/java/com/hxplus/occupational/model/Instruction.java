package com.hxplus.occupational.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instruction")
public class Instruction {

	private Long id;
	private String instruction;
	private List<Diagnostic> diagnostics;
	private Consult consult;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name="instruction")
	public String getInstruction() {
		return instruction;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id")
	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="id")
	public Consult getConsult() {
		return consult;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public void setDiagnostics(List<Diagnostic> diagnostics) {
		this.diagnostics = diagnostics;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

}
