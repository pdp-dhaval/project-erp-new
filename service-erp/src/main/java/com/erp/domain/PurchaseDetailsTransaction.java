package com.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import com.erp.domain.master.ERPMaster;

/**
 * The persistent class for the purchase_details_transaction database table.
 * 
 */
@Entity
@Table(name = "purchase_details_transaction")
public class PurchaseDetailsTransaction extends ERPMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "erp_id")
	private ERPMaster erpMaster;

	private BigDecimal discount;

	@Column(name = "free_quantity")
	private Integer freeQuantity;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "purchase_detail_id")
	private Long purchaseDetailId;

	private Integer quantity;

	private Integer unit;

	public PurchaseDetailsTransaction() {
		super();
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Integer getFreeQuantity() {
		return freeQuantity;
	}

	public void setFreeQuantity(Integer freeQuantity) {
		this.freeQuantity = freeQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPurchaseDetailId() {
		return purchaseDetailId;
	}

	public void setPurchaseDetailId(Long purchaseDetailId) {
		this.purchaseDetailId = purchaseDetailId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

}