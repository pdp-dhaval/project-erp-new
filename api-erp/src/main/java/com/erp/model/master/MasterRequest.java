package com.erp.model.master;

import java.io.Serializable;

import com.erp.model.common.UserData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer classId; //

	private Integer pageSize; // is startNo -1 and endNo is -1 then get all list

	private Integer pageNo; // is startNo -1 and endNo is -1 then get all list

	private UserData userData;

	public MasterRequest() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

}
