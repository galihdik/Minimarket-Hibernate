package com.lawencon.minimarket.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 * @author Galih Dika
 *
 */

public class BaseService {
	private SessionFactory sessionFactory;
	private TransactionTemplate transactionTemplate;

	public Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
}
