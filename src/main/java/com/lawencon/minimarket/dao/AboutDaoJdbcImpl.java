package com.lawencon.minimarket.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.About;

/**
 *
 * @author Galih Dika
 *
 */

public class AboutDaoJdbcImpl extends BaseDao implements AboutDao {

	@Override
	public List<About> getListAbout() throws Exception {
		List<About> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_about";
		listResult = getJdbcTemplate().query(sql, (rs, ro) -> {
			About about = new About();
			about.setIdAbout(rs.getLong("id_about"));
			about.setNameAbout(rs.getString("name_about"));
			about.setLocationAbout(rs.getString("location_about"));
			return about;
		});
		return listResult;
	}

	@Override
	public void insertData(About about) throws Exception {
		String sql = bBuilder("insert into tb_m_about (name_about,location_about) values (? , ? ) ").toString();
		Object[] params = new Object[] { about.getNameAbout(), about.getLocationAbout() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };
		getJdbcTemplate().update(sql, params, types);
	}

	@Override
	public About getAboutByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
