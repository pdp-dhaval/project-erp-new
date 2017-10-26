package com.erp.domain.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * The persistent class for the permission_master database table.
 * 
 */
@Entity
@Table(name="permission_master")
@NamedQuery(name="PermissionMaster.findAll", query="SELECT p FROM PermissionMaster p")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class PermissionMaster extends ErpMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	@Column(name="org_id")
	private Long organizationId;

	public PermissionMaster() {
		super();
	}
	
	public PermissionMaster(Long erpId) {
		super(erpId);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

}