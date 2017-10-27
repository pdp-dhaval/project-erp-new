package model.master;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.DataRequest;
import model.common.ERPRequest;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequest extends ERPRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private DataRequest category;

	private DataRequest company;

	private String productCode;

	private String productDescription;

	private String productName;

	private Double purchasePrice;

	private Long unitQuantity;

	public ProductRequest() {
		super();
	}

	public ProductRequest(Long id) {
		super(id);
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public DataRequest getCategory() {
		return category;
	}

	public void setCategory(DataRequest category) {
		this.category = category;
	}

	public DataRequest getCompany() {
		return company;
	}

	public void setCompany(DataRequest company) {
		this.company = company;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public Long getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(Long unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	@Override
	public String toString() {
		return "ProductMasterRequest [category=" + category.toString() + ", company=" + company + ", productCode="
				+ productCode + ", productName=" + productName + ", getOrgId()=" + getOrganizationId() + "]";
	}

}
