package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Supliers;

/**
 *
 * @author Galih Dika
 *
 */

public interface SupliersDao {
	List<Supliers> getListSuplier() throws Exception;

	void insertData(Supliers spl) throws Exception;

	public Supliers getSupliersByCode(String suplier) throws Exception;
}
