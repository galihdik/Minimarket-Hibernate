package com.lawencon.minimarket.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Roles;

/**
 *
 * @author Galih Dika
 *
 */

public class RolesDaoJdbcImpl extends BaseDao implements RolesDao {
	@Override
	public List<Roles> getListRoles() throws Exception {
		List<Roles> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_roles";
		listResult = getJdbcTemplate().query(sql, (rs, ro) -> {
			Roles roles = new Roles();
			roles.setIdRoles(rs.getLong("id_roles"));
			roles.setNameRoles(rs.getString("name_roles"));
			roles.setCodeRoles(rs.getString("code_roles"));
			return roles;
		});
		return listResult;
	}

	@Override
	public void insertData(Roles rl) throws Exception {
		String sql = bBuilder("insert into tb_m_roles (name_roles,code_roles)", " values (? , ?) ").toString();
		Object[] params = new Object[] { rl.getNameRoles(), rl.getCodeRoles() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };
		getJdbcTemplate().update(sql, params, types);
	}

	@Override
	public Roles getRolesByCode(String roles) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
