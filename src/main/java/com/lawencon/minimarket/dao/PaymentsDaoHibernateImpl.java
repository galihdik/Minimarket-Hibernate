package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Payments;

/**
 *
 * @author Galih Dika
 *
 */

public class PaymentsDaoHibernateImpl extends BaseDao implements PaymentsDao {

	@Override
	public Payments getPaymentsType(String payment) throws Exception {
		List<Payments> listResult = getSession().createQuery("from Payments where paymentCode = ?1", Payments.class)
				.setParameter(1, payment).list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public List<Payments> getListPayments() throws Exception {
		List<Payments> listResult = getSession().createQuery("from Payments", Payments.class).list();
		return listResult;
	}

	@Override
	public void insertData(Payments py) throws Exception {
		getSession().persist(py);
	}

}
