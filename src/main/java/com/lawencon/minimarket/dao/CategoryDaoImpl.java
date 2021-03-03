package com.lawencon.minimarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Category;

/**
 *
 * @author Galih Dika
 *
 */

public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	@Override
	public List<Category> getListCategory() throws Exception {
		List<Category> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_m_category");
		while (rs.next()) {
			Category ct = new Category();
			ct.setIdCategory(rs.getLong("id_category"));
			ct.setCategoryName(rs.getString("category_name"));
			ct.setCategoryCode(rs.getString("category_code"));
			listResult.add(ct);
		}
		return listResult;
	}

	@Override
	public void insertData(Category ctgry) throws Exception {
		String sql = bBuilder("insert into tb_m_category (category_name,category_code) values (? , ? ) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, ctgry.getCategoryName());
		ps.setString(2, ctgry.getCategoryCode());
		ps.executeUpdate();
	}
}
