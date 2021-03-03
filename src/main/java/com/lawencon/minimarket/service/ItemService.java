package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Items;

/**
 *
 * @author Galih Dika
 *
 */

public interface ItemService {
	public Items getItemByCode(String code) throws Exception;

	public List<Items> getItem() throws Exception;

	public void insertData(Items item) throws Exception;
}
