package com.erp.model.other;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the role_permission_mapping database table.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RolePermissionMappingRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Long> roleIds;

	private List<Long> permissionIds;

	public RolePermissionMappingRequest() {
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public List<Long> getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(List<Long> permissionIds) {
		this.permissionIds = permissionIds;
	}
}