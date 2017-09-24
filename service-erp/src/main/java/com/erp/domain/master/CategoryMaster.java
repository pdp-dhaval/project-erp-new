package com.erp.domain.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the category_master database table.
 * 
 */
@Entity
@Table(name = "category_master")
@NamedQuery(name = "CategoryMaster.findAll", query = "SELECT c FROM CategoryMaster c")
public class CategoryMaster extends ERPMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "erp_id")
	private ERPMaster erpMaster;

	@Column(name = "category_name")
	private String categoryName;

	public CategoryMaster() {
		super();
	}

	public ERPMaster getErpMaster() {
		return erpMaster;
	}

	public void setErpMaster(ERPMaster erpMaster) {
		this.erpMaster = erpMaster;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryMaster [getId()=" + getId() + "]";
	}
}