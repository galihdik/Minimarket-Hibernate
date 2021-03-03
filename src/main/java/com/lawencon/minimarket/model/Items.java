package com.lawencon.minimarket.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author Galih Dika
 *
 */

public class Items {
	private Long idItems;
	private String nameItems;
	private BigDecimal priceItems;
	private LocalDateTime expiredItems;
	private String codeItems;
	private Integer stockItems;
	private Category idCategory;
	private Supliers idSupliers;

	public Long getIdItems() {
		return idItems;
	}

	public void setIdItems(Long idItems) {
		this.idItems = idItems;
	}

	public String getNameItems() {
		return nameItems;
	}

	public void setNameItems(String nameItems) {
		this.nameItems = nameItems;
	}

	public BigDecimal getPriceItems() {
		return priceItems;
	}

	public void setPriceItems(BigDecimal priceItems) {
		this.priceItems = priceItems;
	}

	public LocalDateTime getExpiredItems() {
		return expiredItems;
	}

	public void setExpiredItems(LocalDateTime expiredItems) {
		this.expiredItems = expiredItems;
	}

	public Integer getStockItems() {
		return stockItems;
	}

	public void setStockItems(Integer stockItems) {
		this.stockItems = stockItems;
	}

	public Category getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Category idCategory) {
		this.idCategory = idCategory;
	}

	public Supliers getIdSupliers() {
		return idSupliers;
	}

	public void setIdSupliers(Supliers idSupliers) {
		this.idSupliers = idSupliers;
	}

	public String getCodeItems() {
		return codeItems;
	}

	public void setCodeItems(String codeItems) {
		this.codeItems = codeItems;
	}
}
