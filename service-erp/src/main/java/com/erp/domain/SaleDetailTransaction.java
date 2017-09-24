package com.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import com.erp.domain.master.ERPMaster;

import model.common.ErpResponse;

import java.util.Date;

/**
 * The persistent class for the sale_detail_transaction database table.
 * 
 */
@Entity
@Table(name = "sale_detail_transaction")
public class SaleDetailTransaction extends ERPMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "erp_id")
	private ERPMaster erpMaster;

	private BigDecimal discount;

	@Column(name = "free_quantity")
	private Long freeQuantity;

	@Column(name = "product_id")
	private Long productId;

	private Long quantity;

	private BigDecimal rate;

	@Column(name = "sale_detail_id")
	private Long saleDetailId;

	private Integer unit;

	public SaleDetailTransaction() {
		super();
	}


	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Long getFreeQuantity() {
		return freeQuantity;
	}

	public void setFreeQuantity(Long freeQuantity) {
		this.freeQuantity = freeQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Long getSaleDetailId() {
		return saleDetailId;
	}

	public void setSaleDetailId(Long saleDetailId) {
		this.saleDetailId = saleDetailId;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

}