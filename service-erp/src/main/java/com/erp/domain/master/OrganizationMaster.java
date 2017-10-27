package com.erp.domain.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * The persistent class for the organization_master database table.
 * 
 */
@Entity
@Table(name="organization_master")
@NamedQuery(name="OrganizationMaster.findAll", query="SELECT o FROM OrganizationMaster o")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class OrganizationMaster extends ErpMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="account_id")
	private Long accountId;

	@Column(name="user_id")
	private Long userId;

	public OrganizationMaster() {
		super();
	}
	public OrganizationMaster(Long erpId) {
		super(erpId);
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}