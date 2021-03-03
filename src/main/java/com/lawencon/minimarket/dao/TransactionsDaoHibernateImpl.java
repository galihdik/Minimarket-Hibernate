package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public class TransactionsDaoHibernateImpl extends BaseDao implements TransactionsDao {

	@Override
	public List<Transactions> getListTransactions() throws Exception {
		List<Transactions> listResult = getSession().createQuery("from Transactions", Transactions.class).list();
		return listResult;
	}

	@Override
	public Transactions insertData(Transactions transaction) throws Exception {
		getSession().persist(transaction);
		return transaction;
	}

	@Override
	public void updateData(Transactions transaction) throws Exception {
		getSession().createQuery(" update Transactions set priceTotal =  ?1 where idTransaction = ?2 ")
				.setParameter(1, transaction.getPriceTotal()).setParameter(2, transaction.getIdTransaction())
				.executeUpdate();
	}

}
