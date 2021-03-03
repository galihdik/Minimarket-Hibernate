package com.lawencon.minimarket.model;

import java.math.BigDecimal;

/**
 *
 * @author Galih Dika
 *
 */

public class DetailTransactions {
	private Long idDetailTransaction;
	private Integer qty;
	private Items idItems;
	private BigDecimal price;
	private Transactions idTransaction;

	public Long getIdDetailTransaction() {
		return idDetailTransaction;
	}

	public void setIdDetailTransaction(Long idDetailTransaction) {
		this.idDetailTransaction = idDetailTransaction;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Items getIdItems() {
		return idItems;
	}

	public void setIdItems(Items idItems) {
		this.idItems = idItems;
	}

	public Transactions getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(Transactions idTransaction) {
		this.idTransaction = idTransaction;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
