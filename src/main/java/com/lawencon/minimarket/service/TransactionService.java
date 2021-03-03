package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.DetailTransactions;
import com.lawencon.minimarket.model.Items;
import com.lawencon.minimarket.model.Payments;
import com.lawencon.minimarket.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public interface TransactionService {
	public void addData(List<DetailTransactions> trxDetail, Transactions transaction) throws Exception;

	public List<Transactions> getTransaction() throws Exception;

	public Items getItem(String code) throws Exception;

	public Payments getPayments(String code) throws Exception;

}
