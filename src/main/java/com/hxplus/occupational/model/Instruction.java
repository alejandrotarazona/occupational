package com.hxplus.occupational.model;

import java.util.List;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "instruction")
public class Instruction {

	private Long id;
	private String instruction;
	private Consult consult;
	private List<Diagnostic> diagnostics;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "instruction")
	public String getInstruction() {
		return instruction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idconsult", referencedColumnName = "id")
	@JsonBackReference
	public Consult getConsult() {
		return consult;
	}

	@ManyToMany
	@JoinTable(name = "have_inst", inverseJoinColumns = @JoinColumn(name = "iddiagnstic", referencedColumnName = "idconsult"), joinColumns = @JoinColumn(name = "idinstruction", referencedColumnName = "id"))
	public List<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public void setDiagnostics(List<Diagnostic> diagnostics) {
		this.diagnostics = diagnostics;
	}

}
