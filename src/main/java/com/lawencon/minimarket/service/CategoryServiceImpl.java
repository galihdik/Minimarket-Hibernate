package com.lawencon.minimarket.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.minimarket.dao.CategoryDao;
import com.lawencon.minimarket.model.Category;

/**
 *
 * @author Galih Dika
 *
 */

public class CategoryServiceImpl extends BaseService implements CategoryService {
	private CategoryDao categoryDao;
	private TransactionTemplate transactionTemplate;

	public CategoryServiceImpl(CategoryDao categoryDao, TransactionTemplate transactionTemplate) {
		this.categoryDao = categoryDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Category> getCategory() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				categoryDao.getListCategory();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(Category ctgry) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				categoryDao.insertData(ctgry);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

	}
}
