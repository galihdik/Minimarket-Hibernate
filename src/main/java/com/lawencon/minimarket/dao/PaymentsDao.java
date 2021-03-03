package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Payments;

/**
 *
 * @author Galih Dika
 *
 */

public interface PaymentsDao {
	public Payments getPaymentsType(String payment) throws Exception;

	List<Payments> getListPayments() throws Exception;

	void insertData(Payments py) throws Exception;
}
