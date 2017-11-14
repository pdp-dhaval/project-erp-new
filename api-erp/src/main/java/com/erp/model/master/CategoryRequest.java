package com.erp.model.master;

import java.io.Serializable;

import com.erp.model.common.ERPRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryRequest extends ERPRequest implements Serializable {

	private static final long serialVersionUID = -2575021566991066421L;

	private String categoryName;

	private Long organizationId;

	public CategoryRequest() {
		super();
	}

	public CategoryRequest(Long id) {
		super(id);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public String toString() {
		return "CategoryMasterRequest [categoryName=" + categoryName + ", getId()=" + getErpId() + "]";
	}

}
