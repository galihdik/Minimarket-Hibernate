package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Category;

/**
 *
 * @author Galih Dika
 *
 */

public interface CategoryService {
	public List<Category> getCategory() throws Exception;

	public void addData(Category ctgry) throws Exception;
}
