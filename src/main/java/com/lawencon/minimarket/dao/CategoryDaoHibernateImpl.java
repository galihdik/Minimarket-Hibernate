package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Category;

/**
 *
 * @author Galih Dika
 *
 */

public class CategoryDaoHibernateImpl extends BaseDao implements CategoryDao {

	@Override
	public List<Category> getListCategory() throws Exception {
		List<Category> listResult = getSession().createQuery("from Category", Category.class).list();
		return listResult;
	}

	@Override
	public void insertData(Category ctgry) throws Exception {
		getSession().persist(ctgry);
	}

}
