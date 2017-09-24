package com.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import com.erp.domain.master.ERPMaster;

import java.util.Date;

/**
 * The persistent class for the purchase_detail database table.
 * 
 */
@Entity
@Table(name = "purchase_detail")
public class PurchaseDetail extends ERPMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "erp_id")
	private ERPMaster erpMaster;
	
	@Column(name = "account_id")
	private Long accountId;

	private BigDecimal adjustment;

	@Column(name = "bill_number")
	private String billNumber;

	private BigDecimal discount;

	@Column(name = "invoice_number")
	private String invoiceNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "purchase_date")
	private Date purchaseDate;

	private BigDecimal rate;

	@Column(name = "tax_id")
	private Integer taxId;

	private BigDecimal total;

	public PurchaseDetail() {
		super();
	}

	public ERPMaster getErpMaster() {
		return erpMaster;
	}


	public void setErpMaster(ERPMaster erpMaster) {
		this.erpMaster = erpMaster;
	}


	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public BigDecimal getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(BigDecimal adjustment) {
		this.adjustment = adjustment;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Integer getTaxId() {
		return taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}