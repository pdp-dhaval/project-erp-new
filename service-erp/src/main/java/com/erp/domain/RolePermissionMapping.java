package com.erp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.erp.domain.master.PermissionMaster;
import com.erp.domain.master.RoleMaster;

/**
 * The persistent class for the role_permission_mapping database table.
 * 
 */
@Entity
@Table(name = "role_permission_mapping")
@NamedQuery(name = "RolePermissionMapping.findAll", query = "SELECT r FROM RolePermissionMapping r")
public class RolePermissionMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "created_by")
	private Long createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "updated_by")
	private Long updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate;

	// bi-directional many-to-one association to PermissionMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permission_id")
	private PermissionMaster permissionMaster;

	// bi-directional many-to-one association to RoleMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private RoleMaster roleMaster;

	public RolePermissionMapping() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public PermissionMaster getPermissionMaster() {
		return this.permissionMaster;
	}

	public void setPermissionMaster(PermissionMaster permissionMaster) {
		this.permissionMaster = permissionMaster;
	}

	public RoleMaster getRoleMaster() {
		return this.roleMaster;
	}

	public void setRoleMaster(RoleMaster roleMaster) {
		this.roleMaster = roleMaster;
	}

}