package com.erp.model.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5379677952503785583L;

	private Long userId;
	private Long parentId;

	public UserData() {

	}

	public UserData(Long userId) {
		this.userId = userId;
	}

	public UserData(Long userId, Long parentId) {
		this.userId = userId;
		this.parentId = parentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
