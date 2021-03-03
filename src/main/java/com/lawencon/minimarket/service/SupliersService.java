package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Supliers;

/**
 *
 * @author Galih Dika
 *
 */

public interface SupliersService {
	public List<Supliers> getSupliers() throws Exception;

	public void addData(Supliers sp) throws Exception;

	public Supliers getSupliersByCode(String code) throws Exception;
}
