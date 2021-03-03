package com.lawencon.minimarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Supliers;

/**
 *
 * @author Galih Dika
 *
 */

public class SupliersDaoImpl extends BaseDao implements SupliersDao {
	@Override
	public List<Supliers> getListSuplier() throws Exception {
		List<Supliers> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_m_supliers");
		while (rs.next()) {
			Supliers supliers = new Supliers();
			supliers.setIdSupliers(rs.getLong("id_supliers"));
			supliers.setNameSupliers(rs.getString("name_supliers"));
			supliers.setPhoneNumber(rs.getString("phone_number"));
			supliers.setLocationSupliers(rs.getString("location_supliers"));
			listResult.add(supliers);
		}
		return listResult;
	}

	@Override
	public void insertData(Supliers spl) throws Exception {
		String sql = bBuilder("insert into tb_m_supliers (name_supliers,phone_number,location_supliers,suplier_code)",
				" values (? , ? ,? , ?) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, spl.getNameSupliers());
		ps.setString(2, spl.getPhoneNumber());
		ps.setString(3, spl.getLocationSupliers());
		ps.setString(4, spl.getSuplierCode());
		ps.executeUpdate();
	}

	@Override
	public Supliers getSupliersByCode(String suplier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
