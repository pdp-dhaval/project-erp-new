package model.other;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.ERPRequest;

/**
 * The persistent class for the sale_detail database table.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaleRequest extends ERPRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double adjustment;

	private String billNumber;

	private Double cgst;

	private Double discount;

	private String invoiceNumber;

	private Double netAmount;

	private Integer paymentMode;

	private Date salesDate;

	private Double sgst;

	private Long accountId;

	private List<SaleTransactionRequest> saleTransactions;

	public SaleRequest() {
		super();
		saleTransactions = Collections.emptyList();
	}

	public SaleRequest(Long id) {
		super(id);
		saleTransactions = Collections.emptyList();
	}

	public Double getAdjustment() {
		return this.adjustment;
	}

	public void setAdjustment(Double adjustment) {
		this.adjustment = adjustment;
	}

	public String getBillNumber() {
		return this.billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Double getCgst() {
		return this.cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Double getNetAmount() {
		return this.netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Integer getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(Integer paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Date getSalesDate() {
		return this.salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public Double getSgst() {
		return this.sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public List<SaleTransactionRequest> getSaleTransactions() {
		return saleTransactions;
	}

	public void setSaleTransactions(List<SaleTransactionRequest> saleTransactions) {
		this.saleTransactions = saleTransactions;
	}

}