package com.hxplus.occupational.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "contract")
public class Contract {

	private Long id;
	private Date beginDate;
	private Date endDate;
	private User user;
	private Post post;
	private CostCenter costCenter;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "begindate")
	public Date getBeginDate() {
		return beginDate;
	}

	@Column(name="enddate")
	public Date getEndDate() {
		return endDate;
	}

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "iduser", referencedColumnName = "id")
	public User getUser() {
		return user;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idpost", referencedColumnName = "id")
	public Post getPost() {
		return post;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idcostcenter", referencedColumnName = "id")
	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
