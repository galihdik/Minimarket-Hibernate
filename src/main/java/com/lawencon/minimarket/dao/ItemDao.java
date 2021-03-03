package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Items;

/**
 *
 * @author Galih Dika
 *
 */

public interface ItemDao {

	public Items getItemByCode(String code) throws Exception;

	List<Items> getListItem() throws Exception;

	void insertData(Items item) throws Exception;
}
