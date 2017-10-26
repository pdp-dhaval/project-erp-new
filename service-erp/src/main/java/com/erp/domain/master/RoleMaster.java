package com.erp.domain.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * The persistent class for the role_master database table.
 * 
 */
@Entity
@Table(name = "role_master")
@NamedQuery(name = "RoleMaster.findAll", query = "SELECT r FROM RoleMaster r")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class RoleMaster extends ErpMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	@Column(name = "user_id")
	private Long userId;

	public RoleMaster() {
		super();
	}
	public RoleMaster(Long erpId) {
		super(erpId);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}