package com.lawencon.minimarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.About;

/**
 *
 * @author Galih Dika
 *
 */

public class AboutDaoImpl extends BaseDao implements AboutDao {

	@Override
	public List<About> getListAbout() throws Exception {
		List<About> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_m_about");
		while (rs.next()) {
			About about = new About();
			about.setIdAbout(rs.getLong("id_about"));
			about.setNameAbout(rs.getString("name_about"));
			about.setLocationAbout(rs.getString("location_about"));
			listResult.add(about);
		}
		return listResult;
	}

	@Override
	public void insertData(About about) throws Exception {
		String sql = bBuilder("insert into tb_m_about (name_about,location_about) values (? , ? ) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, about.getNameAbout());
		ps.setString(2, about.getLocationAbout());
		ps.executeUpdate();
	}

	@Override
	public About getAboutByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
