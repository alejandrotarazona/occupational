package com.hxplus.occupational.model;

import java.sql.Timestamp;

public class BaseEntity {
	
	private Byte delete;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public Byte getDelete() {
		return delete;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setDelete(Byte delete) {
		this.delete = delete;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
