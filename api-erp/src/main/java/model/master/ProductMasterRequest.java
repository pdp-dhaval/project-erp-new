package model.master;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.DataRequest;
import model.common.ERPRequest;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductMasterRequest extends ERPRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private DataRequest category;

	private DataRequest company;

	private String productCode;

	private String productDescription;

	private String productName;

	private BigDecimal purchasePrice;

	private Long unitQuantity;

	public ProductMasterRequest() {
		super();
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

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Long getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(Long unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	@Override
	public String toString() {
		return "ProductMasterRequest [category=" + category.toString() + ", company=" + company + ", productCode=" + productCode
				+ ", productName=" + productName + ", getOrgId()=" + getOrgId() + "]";
	}
	
	

}
