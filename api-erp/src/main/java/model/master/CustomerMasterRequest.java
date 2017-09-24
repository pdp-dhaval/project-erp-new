package model.master;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.DataRequest;
import model.common.ERPRequest;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerMasterRequest extends ERPRequest implements Serializable {

	private static final long serialVersionUID = 8607584267468623700L;

	private Long accountId;

	private Integer customerType;

	private DataRequest route;

	public CustomerMasterRequest() {
		super();
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

	public DataRequest getRoute() {
		return route;
	}

	public void setRoute(DataRequest route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "CustomerMasterRequest [route=" + (route != null ? route.toString() : route) + ", getOrgId()="
				+ getOrgId() + "]";
	}

}
