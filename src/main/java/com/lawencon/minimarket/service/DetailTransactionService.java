package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.DetailTransactions;
import com.lawencon.minimarket.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public interface DetailTransactionService {
	public void addData(List<DetailTransactions> trx, Transactions idTransaction) throws Exception;
}
