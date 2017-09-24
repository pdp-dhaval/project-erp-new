package com.erp.domain.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the company_master database table.
 * 
 */
@Entity
@Table(name="company_master")
public class CompanyMaster extends ERPMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@OneToOne
	@JoinColumn(name = "erp_id")
	private ERPMaster erpMaster;
	
	@Column(name="account_id")
	private Long accountId;

	@Column(name="company_code")
	private String companyCode;

	@Column(name="company_name")
	private String companyName;

	public CompanyMaster() {
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
		return "CompanyMaster [getId()=" + getId() + "]";
	}
	
}