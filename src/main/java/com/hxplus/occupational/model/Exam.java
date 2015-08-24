package com.hxplus.occupational.model;

import java.io.File;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {

	private Long id;
	private Date orderedAt;
	private Consult ordered;
	private Date receivedAt;
	private List<Consult> received;
	private String type;
	private File results;
	private List<Diagnostic> diagnostics;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name="orderedat")
	public Date getOrderedAt() {
		return orderedAt;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idconsult",referencedColumnName="id")
	public Consult getOrdered() {
		return ordered;
	}

	@Column(name="recievedat")
	public Date getReceivedAt() {
		return receivedAt;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recieve_exam", 
	inverseJoinColumns= { @JoinColumn(name = "idconsult", nullable = false, updatable = false) }, 
	joinColumns = { @JoinColumn(name = "idexam", nullable = false, updatable = false)}
	)
	public List<Consult> getReceived() {
		return received;
	}

	@Column(name="type")
	public String getType() {
		return type;
	}

	@Column(name="results")
	public File getResults() {
		return results;
	}

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="exam")
	public List<Diagnostic> getDiagnostic() {
		return diagnostics;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrderedAt(Date orderedAt) {
		this.orderedAt = orderedAt;
	}

	public void setOrdered(Consult ordered) {
		this.ordered = ordered;
	}

	public void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}

	public void setReceived(List<Consult> received) {
		this.received = received;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setResults(File results) {
		this.results = results;
	}

	public void setDiagnostic(List<Diagnostic> diagnostics) {
		this.diagnostics = diagnostics;
	}

}
