package model.other;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import model.common.ERPRequest;

/**
 * The persistent class for the purchase_detail database table.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseRequest extends ERPRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Double adjustment;

	private String billNumber;

	private Double discount;

	private String invoiceNumber;

	private Date purchaseDate;

	private Double rate;

	private Integer taxId;

	private Double total;

	private Long accountId;

	private List<PurchaseTransactionRequest> purchaseTransactions;

	public PurchaseRequest() {
		super();
		purchaseTransactions = Collections.emptyList();
	}

	public PurchaseRequest(Long erpId) {
		super(erpId);
		purchaseTransactions = Collections.emptyList();
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

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Double getRate() {
		return this.rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer getTaxId() {
		return this.taxId;
	}

	public void setTaxId(Integer taxId) {
		this.taxId = taxId;
	}

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public List<PurchaseTransactionRequest> getPurchaseTransactions() {
		return purchaseTransactions;
	}

	public void setPurchaseTransactions(List<PurchaseTransactionRequest> purchaseTransactions) {
		this.purchaseTransactions = purchaseTransactions;
	}
}