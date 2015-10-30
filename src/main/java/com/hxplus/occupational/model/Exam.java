package com.hxplus.occupational.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "exam")
public class Exam {

	private Long id;
	private Consult ordered;
	private List<Consult> received;
	private String type;
	private File results;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ordered", referencedColumnName = "id")
	public Consult getOrdered() {
		return ordered;
	}

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recieve_exam", 
			joinColumns = { @JoinColumn(name = "idexam", referencedColumnName ="id", nullable = false, updatable = false)},
			inverseJoinColumns = { @JoinColumn(name = "idconsult", referencedColumnName ="id", nullable = false, updatable = false) })
	public List<Consult> getReceived() {
		return received;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	@JsonIgnore
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "results", referencedColumnName = "id")
	public File getResults() {
		return results;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrdered(Consult ordered) {
		this.ordered = ordered;
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

}
