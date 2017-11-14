package com.erp.model.master;

import java.io.Serializable;

import com.erp.model.common.DataRequest;
import com.erp.model.common.ERPRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequest extends ERPRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long accountId;

	private String address;

	private DataRequest city;

	private DataRequest country;
	
	private String pincode;
	
	public AddressRequest() {
		super();
	}

	public AddressRequest(Long id) {
		super(id);
	}
	public DataRequest getCity() {
		return city;
	}

	public void setCity(DataRequest city) {
		this.city = city;
	}

	public DataRequest getCountry() {
		return country;
	}

	public void setCountry(DataRequest country) {
		this.country = country;
	}

	public DataRequest getState() {
		return state;
	}

	public void setState(DataRequest state) {
		this.state = state;
	}

	private DataRequest state;

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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
}
