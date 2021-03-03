package com.lawencon.minimarket.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public class ProfilesDaoJdbcImpl extends BaseDao implements ProfilesDao {
	@Override
	public List<Profiles> getListProfile() throws Exception {
		List<Profiles> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_profiles";
		listResult = getJdbcTemplate().query(sql, (rs, ro) -> {
			Profiles profile = new Profiles();
			profile.setIdProfiles(rs.getLong("id_profiles"));
			profile.setAddressProfile(rs.getString("address_profile"));
			profile.setNameProfile(rs.getString("name_profile"));
			profile.setProfileCode(rs.getString("profile_code"));
			return profile;
		});
		return listResult;
	}

	@Override
	public void insertData(Profiles prf) throws Exception {
		String sql = bBuilder("insert into tb_m_profiles (address_profile,name_profile,profile_code)",
				" values (? , ? ,?) ").toString();
		Object[] params = new Object[] { prf.getAddressProfile(), prf.getNameProfile(), prf.getProfileCode() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		getJdbcTemplate().update(sql, params, types);
	}

	@Override
	public Profiles getProfilesByCode(String profile) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
