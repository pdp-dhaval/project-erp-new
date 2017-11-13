package com.erp.model.master;

import java.io.Serializable;

import com.erp.model.common.UserData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterModel implements Serializable {

	private static final long serialVersionUID = 6507607163344302861L;

	private Integer classId;

	private Object master;

	private UserData userData;

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Object getMaster() {
		return master;
	}

	public void setMaster(Object master) {
		this.master = master;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

}
