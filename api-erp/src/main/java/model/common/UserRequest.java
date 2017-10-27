package model.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the user database table.
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest extends ERPRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;

	private Boolean emailVerified;

	private String mobile;

	private String name;

	private Boolean otpVerified;

	private String password;

	public UserRequest() {
		super();
	}

	public UserRequest(Long erpId) {
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