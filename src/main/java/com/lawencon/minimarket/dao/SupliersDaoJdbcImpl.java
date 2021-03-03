package com.lawencon.minimarket.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Supliers;

/**
 *
 * @author Galih Dika
 *
 */

public class SupliersDaoJdbcImpl extends BaseDao implements SupliersDao {
	@Override
	public List<Supliers> getListSuplier() throws Exception {
		List<Supliers> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_supliers";
		listResult = getJdbcTemplate().query(sql, (rs, ro) -> {
			Supliers supliers = new Supliers();
			supliers.setIdSupliers(rs.getLong("id_supliers"));
			supliers.setNameSupliers(rs.getString("name_supliers"));
			supliers.setPhoneNumber(rs.getString("phone_number"));
			supliers.setLocationSupliers(rs.getString("location_supliers"));
			supliers.setSuplierCode(rs.getString("suplier_code"));
			return supliers;
		});
		return listResult;
	}

	@Override
	public void insertData(Supliers spl) throws Exception {
		String sql = bBuilder("insert into tb_m_supliers (name_supliers,phone_number,location_supliers,suplier_code)",
				" values (? , ? ,? , ?) ").toString();
		Object[] params = new Object[] { spl.getNameSupliers(), spl.getPhoneNumber(), spl.getLocationSupliers(),
				spl.getSuplierCode() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		getJdbcTemplate().update(sql, params, types);
	}

	@Override
	public Supliers getSupliersByCode(String suplier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
