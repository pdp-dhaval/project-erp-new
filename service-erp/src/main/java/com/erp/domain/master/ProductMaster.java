package com.erp.domain.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * The persistent class for the product_master database table.
 * 
 */
@Entity
@Table(name="product_master")
@NamedQuery(name="ProductMaster.findAll", query="SELECT p FROM ProductMaster p")
@PrimaryKeyJoinColumn(referencedColumnName = "erp_id")
public class ProductMaster extends ErpMstr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="product_code")
	private String productCode;

	@Column(name="product_description")
	private String productDescription;

	@Column(name="product_name")
	private String productName;

	@Column(name="purchase_price")
	private Double purchasePrice;

	@Column(name="unit_quantity")
	private Long unitQuantity;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	private CategoryMaster categoryMaster;

	//bi-directional many-to-one association to CompanyMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="company_id")
	private CompanyMaster companyMaster;

	@Column(name="org_id")
	private Long organizationId;

	public ProductMaster() {
		super();
	}
	public ProductMaster(Long erpId) {
		super(erpId);
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Long getUnitQuantity() {
		return this.unitQuantity;
	}

	public void setUnitQuantity(Long unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	public CategoryMaster getCategoryMaster() {
		return this.categoryMaster;
	}

	public void setCategoryMaster(CategoryMaster categoryMaster) {
		this.categoryMaster = categoryMaster;
	}

	public CompanyMaster getCompanyMaster() {
		return this.companyMaster;
	}

	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
	}
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}


	
}