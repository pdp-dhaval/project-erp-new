package com.erp.domain.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * The persistent class for the company_master database table.
 * 
 */
@Entity
@Table(name = "company_master")
@NamedQuery(name = "CompanyMaster.findAll", query = "SELECT c FROM CompanyMaster c")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class CompanyMaster extends AccountMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "company_code")
	private String companyCode;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "org_id")
	private Long organizationId;

	public CompanyMaster() {
	}

	public CompanyMaster(Long erpId) {
		super(erpId);
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

}