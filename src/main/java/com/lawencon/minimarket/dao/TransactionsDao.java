package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public interface TransactionsDao {
	List<Transactions> getListTransactions() throws Exception;

	public Transactions insertData(Transactions transaction) throws Exception;

	public void updateData(Transactions transaction) throws Exception;
}
