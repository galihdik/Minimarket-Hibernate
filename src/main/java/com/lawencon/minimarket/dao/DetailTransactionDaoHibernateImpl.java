package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.DetailTransactions;
import com.lawencon.minimarket.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public class DetailTransactionDaoHibernateImpl extends BaseDao implements DetailTransactionDao {

	@Override
	public List<DetailTransactions> getListDetailTransactions() throws Exception {
		List<DetailTransactions> listResult = getSession()
				.createQuery("from DetailTransactions", DetailTransactions.class).list();
		return listResult;
	}

	@Override
	public void insert(DetailTransactions trx, Transactions idTransaction) throws Exception {
		getSession().persist(trx);
	}

}
