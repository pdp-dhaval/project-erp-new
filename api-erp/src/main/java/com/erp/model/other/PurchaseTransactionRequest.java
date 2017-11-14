package com.erp.model.other;

import java.io.Serializable;

import com.erp.model.common.ERPRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the purchase_details_transaction database table.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseTransactionRequest extends ERPRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double discount;

	private Integer freeQuantity;

	private Integer quantity;

	private Integer unit;

	private Long purchaseDetailId;

	private Long productId;

	public PurchaseTransactionRequest() {
		super();
	}

	public PurchaseTransactionRequest(Long erpId) {
		super(erpId);
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getFreeQuantity() {
		return this.freeQuantity;
	}

	public void setFreeQuantity(Integer freeQuantity) {
		this.freeQuantity = freeQuantity;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getUnit() {
		return this.unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Long getPurchaseDetailId() {
		return purchaseDetailId;
	}

	public void setPurchaseDetailId(Long purchaseDetailId) {
		this.purchaseDetailId = purchaseDetailId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}