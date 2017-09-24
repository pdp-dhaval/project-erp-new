package model.master;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.DataRequest;
import model.common.ERPRequest;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressMasterRequest extends ERPRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long accountId;

	private String address;

	private DataRequest city;

	private DataRequest country;
	
	private String pincode;

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

	public AddressMasterRequest() {
		super();
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
}
