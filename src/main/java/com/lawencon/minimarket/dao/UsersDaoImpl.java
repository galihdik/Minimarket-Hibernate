package com.lawencon.minimarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

public class UsersDaoImpl extends BaseDao implements UsersDao {
	@Override
	public List<Users> getListUsers() throws Exception {
		List<Users> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_m_users");
		while (rs.next()) {
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
			listResult.add(user);
		}
		return listResult;
	}

	@Override
	public Users getUsersByUsernameAndPassword(String username, String pswd) throws Exception {
		Users u = new Users();
		String sql = bBuilder(
				"select u.user_id,u.username,u.pswd,u.id_roles,u.id_profiles,r.code_roles from tb_m_users u ",
				"inner join tb_m_roles r on r.id_roles = u.id_roles ",
				"inner join tb_m_profiles p on p.id_profiles = u.id_profiles ", "where u.username = ? and u.pswd = ?")
						.toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, pswd);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			u.setUserId(rs.getLong("user_id"));
			u.setUsername(rs.getString("username"));
			u.setPswd(rs.getString("pswd"));

			Roles rl = new Roles();
			rl.setIdRoles(rs.getLong("id_roles"));
			rl.setCodeRoles(rs.getString("code_roles"));
			Profiles pf = new Profiles();
			pf.setIdProfiles(rs.getLong("id_profiles"));
			u.setIdRoles(rl);
			u.setIdProfiles(pf);
			break;
		}
		return u;
	}

	@Override
	public void insertData(Users usr) throws Exception {
		String sql = bBuilder("insert into tb_m_users (username,pswd,id_roles,id_profiles,user_code)",
				" values (? , ? ,? , ? ,?) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, usr.getUsername());
		ps.setString(2, usr.getPswd());
		ps.setLong(3, usr.getIdRoles().getIdRoles());
		ps.setLong(4, usr.getIdProfiles().getIdProfiles());
		ps.setString(5, usr.getUserCode());
		ps.executeUpdate();
	}
}
