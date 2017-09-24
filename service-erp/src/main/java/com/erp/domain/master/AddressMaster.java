package com.erp.domain.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the address_master database table.
 * 
 */
@Entity
@Table(name="address_master")
public class AddressMaster extends ERPMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "erp_id")
	private ERPMaster erpMaster;
	
	@Column(name="account_id")
	private Long accountId;

	private String address;

	@Column(name="city_id")
	private Long cityId;

	@Column(name="country_id")
	private Long countryId;

	private String pincode;

	@Column(name="state_id")
	private Long stateId;

	public AddressMaster() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "AddressMaster [getId()=" + getId() + "]";
	}
	
}