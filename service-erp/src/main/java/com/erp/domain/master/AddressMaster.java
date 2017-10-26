package com.erp.domain.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * The persistent class for the address_master database table.
 * 
 */
@Entity
@Table(name = "address_master")
@NamedQuery(name = "AddressMaster.findAll", query = "SELECT a FROM AddressMaster a")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class AddressMaster extends ErpMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;

	@Column(name = "city_id")
	private Long cityId;

	@Column(name = "country_id")
	private Long countryId;

	private String pincode;

	@Column(name = "state_id")
	private Long stateId;

	@Column(name = "account_id")
	private Long accountId;

	@Column(name = "org_id")
	private Long organizationIds;

	@Column(name = "user_id")
	private Long userId;

	public AddressMaster() {
		super();
	}
	
	public AddressMaster(Long erpId) {
		super(erpId);
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Long getStateId() {
		return this.stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getOrganizationIds() {
		return organizationIds;
	}

	public void setOrganizationIds(Long organizationIds) {
		this.organizationIds = organizationIds;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}