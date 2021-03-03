package com.lawencon.minimarket.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Category;

/**
 *
 * @author Galih Dika
 *
 */

public class CategoryDaoJdbcImpl extends BaseDao implements CategoryDao {

	@Override
	public List<Category> getListCategory() throws Exception {
		List<Category> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_category";
		listResult = getJdbcTemplate().query(sql, (rs, ro) -> {
			Category ct = new Category();
			ct.setIdCategory(rs.getLong("id_category"));
			ct.setCategoryName(rs.getString("category_name"));
			ct.setCategoryCode(rs.getString("category_code"));
			return ct;
		});
		return listResult;
	}

	@Override
	public void insertData(Category ctgry) throws Exception {
		String sql = bBuilder("insert into tb_m_category (category_name,category_code) values (? , ? ) ").toString();
		Object[] params = new Object[] { ctgry.getCategoryName(), ctgry.getCategoryCode() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };
		getJdbcTemplate().update(sql, params, types);
	}

}
