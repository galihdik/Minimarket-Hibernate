package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public class UsersDaoHibernateImpl extends BaseDao implements UsersDao {

	@Override
	public List<Users> getListUsers() throws Exception {
		List<Users> listResult = getSession().createQuery("from Users", Users.class).list();
		return listResult;
	}

	@Override
	public Users getUsersByUsernameAndPassword(String username, String pswd) throws Exception {
		List<Users> listResult = getSession().createQuery("from Users where username = ?1  and pswd = ?2", Users.class)
				.setParameter(1, username).setParameter(2, pswd).list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public void insertData(Users usr) throws Exception {
		getSession().persist(usr);
	}

}
