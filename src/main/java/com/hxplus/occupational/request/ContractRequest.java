package com.hxplus.occupational.request;

import java.util.Date;

import com.hxplus.occupational.model.CostCenter;
import com.hxplus.occupational.model.Post;
import com.hxplus.occupational.model.User;

public class ContractRequest {

	private Date beginDate;
	private Date endDate;
	private User user;
	private Post post;
	private CostCenter costCenter;

	public Date getBeginDate() {
		return beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public User getUser() {
		return user;
	}

	public Post getPost() {
		return post;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

}
