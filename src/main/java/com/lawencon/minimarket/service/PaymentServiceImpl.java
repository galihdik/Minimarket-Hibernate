package com.lawencon.minimarket.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.minimarket.dao.PaymentsDao;
import com.lawencon.minimarket.model.Payments;

/**
 *
 * @author Galih Dika
 *
 */

public class PaymentServiceImpl extends BaseService implements PaymentService {
	private PaymentsDao paymentDao;

	private TransactionTemplate transactionTemplate;

	public PaymentServiceImpl(PaymentsDao paymentDao, TransactionTemplate transactionTemplate) {
		this.paymentDao = paymentDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Payments> getPayment() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				paymentDao.getListPayments();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addDataa(Payments py) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				paymentDao.insertData(py);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public Payments getPaymentsByCode(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return paymentDao.getPaymentsType(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}
