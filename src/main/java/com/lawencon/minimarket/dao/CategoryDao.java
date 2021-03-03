package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Category;

/**
 *
 * @author Galih Dika
 *
 */

public interface CategoryDao {
	List<Category> getListCategory() throws Exception;

	void insertData(Category ctgry) throws Exception;
}
