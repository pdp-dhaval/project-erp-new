package com.erp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.erp.domain.master.ErpMstr;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class User extends ErpMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;

	@Column(name = "email_verified")
	private Boolean emailVerified;

	private String mobile;

	private String name;

	@Column(name = "otp_verified")
	private Boolean otpVerified;

	private String password;

	public User() {
		super();
	}

	public User(Long erpId) {
		super(erpId);
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailVerified() {
		return this.emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOtpVerified() {
		return this.otpVerified;
	}

	public void setOtpVerified(Boolean otpVerified) {
		this.otpVerified = otpVerified;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}