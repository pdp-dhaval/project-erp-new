package com.erp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.erp.domain.master.ErpMstr;
import com.erp.domain.master.RoleMaster;

/**
 * The persistent class for the user_role_mapping database table.
 * 
 */
@Entity
@Table(name = "user_role_mapping")
@NamedQuery(name = "UserRoleMapping.findAll", query = "SELECT u FROM UserRoleMapping u")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class UserRoleMapping extends ErpMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private RoleMaster roleMaster;

	@Column(name = "user_id")
	private Long userId;

	public UserRoleMapping() {
		super();
	}

	public UserRoleMapping(Long erpId) {
		super(erpId);
	}

	public RoleMaster getRoleMaster() {
		return this.roleMaster;
	}

	public void setRoleMaster(RoleMaster roleMaster) {
		this.roleMaster = roleMaster;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}