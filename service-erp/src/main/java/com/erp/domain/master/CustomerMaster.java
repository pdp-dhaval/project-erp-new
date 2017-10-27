package com.erp.domain.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * The persistent class for the customer_master database table.
 * 
 */
@Entity
@Table(name = "customer_master")
@NamedQuery(name = "CustomerMaster.findAll", query = "SELECT c FROM CustomerMaster c")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class CustomerMaster extends ErpMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "customer_type")
	private Integer customerType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private AccountMaster accountMaster;

	@Column(name = "org_id")
	private Long organizationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "route_id")
	private RouteMaster routeMaster;

	public CustomerMaster() {
		super();
	}
	
	public CustomerMaster(Long erpId) {
		super(erpId);
	}

	public Integer getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
	}

	public AccountMaster getAccountMaster() {
		return this.accountMaster;
	}

	public void setAccountMaster(AccountMaster accountMaster) {
		this.accountMaster = accountMaster;
	}
	
	public RouteMaster getRouteMaster() {
		return this.routeMaster;
	}

	public void setRouteMaster(RouteMaster routeMaster) {
		this.routeMaster = routeMaster;
	}

}