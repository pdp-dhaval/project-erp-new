package model.master;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.ERPRequest;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyMasterRequest extends ERPRequest implements Serializable {

	private static final long serialVersionUID = 5785154427550524585L;

	private Long accountId;

	private String companyCode;

	private String companyName;

	public CompanyMasterRequest() {
		super();
	}
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "CompanyMasterRequest [companyCode=" + companyCode + ", getId()=" + getId() + "]";
	}

	

}
