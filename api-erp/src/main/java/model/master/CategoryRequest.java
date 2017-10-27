package model.master;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.ERPRequest;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryRequest extends ERPRequest implements Serializable {

	private static final long serialVersionUID = -2575021566991066421L;

	private String categoryName;

	private Long orgId;

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

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@Override
	public String toString() {
		return "CategoryMasterRequest [categoryName=" + categoryName + ", getId()=" + getErpId() + "]";
	}

}
