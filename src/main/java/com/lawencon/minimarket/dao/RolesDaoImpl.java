package com.lawencon.minimarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Roles;

/**
 *
 * @author Galih Dika
 *
 */

public class RolesDaoImpl extends BaseDao implements RolesDao {
	@Override
	public List<Roles> getListRoles() throws Exception {
		List<Roles> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_m_roles");
		while (rs.next()) {
			Roles roles = new Roles();
			roles.setIdRoles(rs.getLong("id_roles"));
			roles.setNameRoles(rs.getString("name_roles"));
			roles.setCodeRoles(rs.getString("code_roles"));
			listResult.add(roles);
		}
		return listResult;
	}

	@Override
	public void insertData(Roles rl) throws Exception {
		String sql = bBuilder("insert into tb_m_roles (name_roles,code_roles)", " values (? , ?) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, rl.getNameRoles());
		ps.setString(2, rl.getCodeRoles());
		ps.executeUpdate();
	}

	@Override
	public Roles getRolesByCode(String roles) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
