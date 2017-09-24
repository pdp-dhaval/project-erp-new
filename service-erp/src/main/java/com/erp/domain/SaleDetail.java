package com.erp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import com.erp.domain.master.ERPMaster;

import java.util.Date;

/**
 * The persistent class for the sale_detail database table.
 * 
 */
@Entity
@Table(name = "sale_detail")
public class SaleDetail  extends ERPMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "erp_id")
	private ERPMaster erpMaster;

	@Column(name = "account_id")
	private Long accountId;

	private BigDecimal adjustment;

	@Column(name = "bill_number")
	private String billNumber;

	private BigDecimal cgst;

	private BigDecimal discount;

	@Column(name = "invoice_number")
	private String invoiceNumber;

	@Column(name = "net_amount")
	private BigDecimal netAmount;

	@Column(name = "payment_mode")
	private Integer paymentMode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sales_date")
	private Date salesDate;

	private BigDecimal sgst;

	public SaleDetail() {
		super();
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

	public BigDecimal getCgst() {
		return cgst;
	}

	public void setCgst(BigDecimal cgst) {
		this.cgst = cgst;
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

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public Integer getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(Integer paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public BigDecimal getSgst() {
		return sgst;
	}

	public void setSgst(BigDecimal sgst) {
		this.sgst = sgst;
	}

}