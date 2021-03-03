package com.lawencon.minimarket.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.minimarket.dao.DetailTransactionDao;
import com.lawencon.minimarket.model.DetailTransactions;
import com.lawencon.minimarket.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public class DetailTransactionServiceImpl extends BaseService implements DetailTransactionService {
	private DetailTransactionDao transactionDetailDao;
	private TransactionTemplate transactionTemplate;

	public DetailTransactionServiceImpl(DetailTransactionDao transactionDetailDao,
			TransactionTemplate transactionTemplate) {
		this.transactionDetailDao = transactionDetailDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public void addData(List<DetailTransactions> trx, Transactions idTransaction) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				for (DetailTransactions detailTransactions : trx) {
					transactionDetailDao.insert(detailTransactions, idTransaction);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

	}

}
