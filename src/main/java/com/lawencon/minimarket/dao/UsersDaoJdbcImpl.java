package com.lawencon.minimarket.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Profiles;
import com.lawencon.minimarket.model.Roles;
import com.lawencon.minimarket.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public class UsersDaoJdbcImpl extends BaseDao implements UsersDao {
	@Override
	public List<Users> getListUsers() throws Exception {
		List<Users> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_users";
		listResult = getJdbcTemplate().query(sql, (rs, ro) -> {
			Users user = new Users();
			user.setUserId(rs.getLong("user_id"));
			user.setUsername(rs.getString("username"));
			user.setPswd(rs.getString("pswd"));

			Roles rl = new Roles();
			rl.setIdRoles(rs.getLong("id_roles"));
			Profiles pf = new Profiles();
			pf.setIdProfiles(rs.getLong("id_profiles"));
			user.setIdRoles(rl);
			user.setIdProfiles(pf);
			return user;
		});
		return listResult;
	}

	@Override
	public Users getUsersByUsernameAndPassword(String username, String pswd) throws Exception {
		String sql = bBuilder(
				"select u.user_id,u.username,u.pswd,u.id_roles,u.id_profiles,r.code_roles ,u.user_code from tb_m_users u ",
				"inner join tb_m_roles r on r.id_roles = u.id_roles ",
				"inner join tb_m_profiles p on p.id_profiles = u.id_profiles ", "where u.username = ? and u.pswd = ?")
						.toString();
		Object[] params = new Object[] { username, pswd };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };
		Users u = getJdbcTemplate().queryForObject(sql, params, types, (rs, ro) -> {
			Users user = new Users();
			user.setUserId(rs.getLong("user_id"));
			user.setUsername(rs.getString("username"));
			user.setPswd(rs.getString("pswd"));

			Roles rl = new Roles();
			rl.setIdRoles(rs.getLong("id_roles"));
			rl.setCodeRoles(rs.getString("code_roles"));
			Profiles pf = new Profiles();
			pf.setIdProfiles(rs.getLong("id_profiles"));
			user.setIdRoles(rl);
			user.setIdProfiles(pf);
			return user;
		});
		return u;
	}

	@Override
	public void insertData(Users usr) throws Exception {
		String sql = bBuilder("insert into tb_m_users (username,pswd,id_roles,id_profiles,user_code)",
				" values (? , ? ,? , ? ,?) ").toString();
		Object[] params = new Object[] { usr.getUsername(), usr.getPswd(), usr.getIdRoles().getIdRoles(),
				usr.getIdProfiles().getIdProfiles(), usr.getUserCode() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.VARCHAR };
		getJdbcTemplate().update(sql, params, types);
	}
}
