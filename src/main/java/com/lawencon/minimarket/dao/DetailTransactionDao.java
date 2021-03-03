package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.DetailTransactions;
import com.lawencon.minimarket.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public interface DetailTransactionDao {
	List<DetailTransactions> getListDetailTransactions() throws Exception;

	public void insert(DetailTransactions trx, Transactions idTransaction) throws Exception;
}
