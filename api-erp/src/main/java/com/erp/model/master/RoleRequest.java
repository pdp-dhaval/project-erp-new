package com.erp.model.master;

import java.io.Serializable;

import com.erp.model.common.ERPRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the role_master database table.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleRequest extends ERPRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	public RoleRequest() {
		super();
	}

	public RoleRequest(Long id) {
		super(id);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}