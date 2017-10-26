package model.other;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.ERPRequest;

/**
 * The persistent class for the sale_detail_transaction database table.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaleTransactionRequest extends ERPRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double discount;

	private Long freeQuantity;

	private Long quantity;

	private Double rate;

	private Integer unit;

	private Long saleDetailId;

	private Long productId;

	public SaleTransactionRequest() {
		super();
	}

	public SaleTransactionRequest(Long id) {
		super(id);
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Long getFreeQuantity() {
		return this.freeQuantity;
	}

	public void setFreeQuantity(Long freeQuantity) {
		this.freeQuantity = freeQuantity;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getRate() {
		return this.rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer getUnit() {
		return this.unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Long getSaleDetailId() {
		return saleDetailId;
	}

	public void setSaleDetailId(Long saleDetailId) {
		this.saleDetailId = saleDetailId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}