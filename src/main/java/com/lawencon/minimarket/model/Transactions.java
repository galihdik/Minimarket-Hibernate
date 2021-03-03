package com.lawencon.minimarket.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Galih Dika
 *
 */

public class Transactions {
	private Long idTransaction;
	private LocalDateTime transactionDate;
	private BigDecimal priceTotal;
	private About idAbout;
	private Payments idPayments;
	private Users idUsers;
	private List<DetailTransactions> detailTransactions;
	private String strukCode;

	public Long getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Long idTransaction) {
		this.idTransaction = idTransaction;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(BigDecimal priceTotal) {
		this.priceTotal = priceTotal;
	}

	public About getIdAbout() {
		return idAbout;
	}

	public void setIdAbout(About idAbout) {
		this.idAbout = idAbout;
	}

	public Payments getIdPayments() {
		return idPayments;
	}

	public void setIdPayments(Payments idPayments) {
		this.idPayments = idPayments;
	}

	public Users getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(Users idUsers) {
		this.idUsers = idUsers;
	}

	public List<DetailTransactions> getDetailTransactions() {
		return detailTransactions;
	}

	public void setDetailTransactions(List<DetailTransactions> detailTransactions) {
		this.detailTransactions = detailTransactions;
	}

	public String getStrukCode() {
		return strukCode;
	}

	public void setStrukCode(String strukCode) {
		this.strukCode = strukCode;
	}
}
