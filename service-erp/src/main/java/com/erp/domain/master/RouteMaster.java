package com.erp.domain.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * The persistent class for the route_master database table.
 * 
 */
@Entity
@Table(name = "route_master")
@NamedQuery(name = "RouteMaster.findAll", query = "SELECT r FROM RouteMaster r")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class RouteMaster extends ErpMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "route_name")
	private String routeName;

	@Column(name = "org_id")
	private Long organizationId;

	@Column(name = "user_id")
	private Long userId;

	public RouteMaster() {
		super();
	}

	public RouteMaster(Long erpId) {
		super(erpId);
	}

	public String getRouteName() {
		return this.routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}