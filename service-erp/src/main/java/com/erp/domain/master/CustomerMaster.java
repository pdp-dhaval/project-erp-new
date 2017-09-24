package com.erp.domain.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_master database table.
 * 
 */
@Entity
@Table(name="customer_master")
public class CustomerMaster extends ERPMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@OneToOne
	@JoinColumn(name = "erp_id")
	private ERPMaster erpMaster;
	
	@Column(name="account_id")
	private Long accountId;

	@Column(name="customer_type")
	private Integer customerType;

	@Column(name="route_id")
	private Long routeId;

	public CustomerMaster() {
		super();
	}
	
	public ERPMaster getErpMaster() {
		return erpMaster;
	}

	public void setErpMaster(ERPMaster erpMaster) {
		this.erpMaster = erpMaster;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Integer getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	@Override
	public String toString() {
		return "CustomerMaster [getId()=" + getId() + "]";
	}
	
}