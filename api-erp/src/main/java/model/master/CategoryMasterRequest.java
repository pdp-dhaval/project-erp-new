package model.master;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.ERPRequest;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryMasterRequest extends ERPRequest implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2575021566991066421L;
	private String categoryName;

	public CategoryMasterRequest() {
		super();
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryMasterRequest [categoryName=" + categoryName + ", getId()=" + getId() + "]";
	}
	
}
