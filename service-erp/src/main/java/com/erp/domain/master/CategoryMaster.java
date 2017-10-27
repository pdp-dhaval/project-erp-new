package com.erp.domain.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * The persistent class for the category_master database table.
 * 
 */
@Entity
@Table(name="category_master")
@NamedQuery(name="CategoryMaster.findAll", query="SELECT c FROM CategoryMaster c")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class CategoryMaster extends ErpMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="category_name")
	private String categoryName;

	@Column(name="org_id")
	private Long organizationId;

	public CategoryMaster() {
		super();
	}
	
	public CategoryMaster(Long erpId) {
		super(erpId);
	}

	public String getCategoryName() {
		return this.categoryName;
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

}