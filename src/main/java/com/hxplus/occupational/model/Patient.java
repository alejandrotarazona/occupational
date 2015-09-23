package com.hxplus.occupational.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patient")
public class Patient extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7746973037890360513L;
	private Long id;
	private User user;
	private History history;
	private List<Doctor> doctors;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "iduser", referencedColumnName = "id")
	public User getUser() {
		return user;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idhistory", referencedColumnName = "id")
	public History getHistory() {
		return history;
	}

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "attends", inverseJoinColumns = { @JoinColumn(name = "iddoctor", referencedColumnName = "id") }, joinColumns = { @JoinColumn(referencedColumnName = "id", name = "idpatient") })
	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
