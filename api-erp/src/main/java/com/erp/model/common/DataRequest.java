package com.erp.model.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataRequest implements Serializable {

	private static final long serialVersionUID = 3084484149747460536L;
	private Long id;
	private String value;
	private Boolean isActive;

	public DataRequest() {
		super();
	}

	public DataRequest(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "DataRequest [id=" + id + ", value=" + value + "]";
	}

}
