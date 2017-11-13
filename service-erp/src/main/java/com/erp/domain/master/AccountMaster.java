package com.erp.domain.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * The persistent class for the account_master database table.
 * 
 */
@Entity
@Table(name = "account_master")
@NamedQuery(name = "AccountMaster.findAll", query = "SELECT a FROM AccountMaster a")
// @Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class AccountMaster extends ErpMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "account_name")
	private String accountName;

	@Column(name = "alias_name")
	private String aliasName;

	@Column(name = "balance_type")
	private Integer balanceType;

	@Column(name = "contact_person_name")
	private String contactPersonName;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "fax_number")
	private String faxNumber;

	@Column(name = "gst_number")
	private String gstNumber;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "opening_balance")
	private Double openingBalance;

	@Column(name = "pan_number")
	private String panNumber;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "user_id")
	private Long userId;

	public AccountMaster() {
		super();
	}

	public AccountMaster(Long erpId) {
		super(erpId);
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAliasName() {
		return this.aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public Integer getBalanceType() {
		return this.balanceType;
	}

	public void setBalanceType(Integer balanceType) {
		this.balanceType = balanceType;
	}

	public String getContactPersonName() {
		return this.contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFaxNumber() {
		return this.faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getGstNumber() {
		return this.gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Double getOpeningBalance() {
		return this.openingBalance;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public String getPanNumber() {
		return this.panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}