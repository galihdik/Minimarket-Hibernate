package com.lawencon.minimarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public class ProfilesDaoImpl extends BaseDao implements ProfilesDao {
	@Override
	public List<Profiles> getListProfile() throws Exception {
		List<Profiles> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_m_profiles");
		while (rs.next()) {
			Profiles profile = new Profiles();
			profile.setIdProfiles(rs.getLong("id_profiles"));
			profile.setAddressProfile(rs.getString("address_profile"));
			profile.setNameProfile(rs.getString("name_profile"));
			listResult.add(profile);
		}
		return listResult;
	}

	@Override
	public void insertData(Profiles prf) throws Exception {
		String sql = bBuilder("insert into tb_m_profiles (address_profile,name_profile,profile_code)",
				" values (? , ? ,?) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, prf.getAddressProfile());
		ps.setString(2, prf.getNameProfile());
		ps.setString(3, prf.getProfileCode());
		ps.executeUpdate();
	}

	@Override
	public Profiles getProfilesByCode(String profile) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
