package model.other;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.ERPRequest;

/**
 * The persistent class for the user_role_mapping database table.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRoleMappingRequest extends ERPRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Long> roleId;

	private List<Long> userId;

	public UserRoleMappingRequest() {
		super();
	}

	public UserRoleMappingRequest(Long erpId) {
		super(erpId);
	}

	public List<Long> getRoleId() {
		return roleId;
	}

	public void setRoleId(List<Long> roleId) {
		this.roleId = roleId;
	}

	public List<Long> getUserId() {
		return userId;
	}

	public void setUserId(List<Long> userId) {
		this.userId = userId;
	}
	

}