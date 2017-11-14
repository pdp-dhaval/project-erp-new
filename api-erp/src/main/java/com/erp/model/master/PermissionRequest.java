package com.erp.model.master;

import java.io.Serializable;

import com.erp.model.common.ERPRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the permission_master database table.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissionRequest extends ERPRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	public PermissionRequest() {
		super();
	}

	public PermissionRequest(Long erpId) {
		super(erpId);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}