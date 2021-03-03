package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public interface UsersDao {
	List<Users> getListUsers() throws Exception;

	Users getUsersByUsernameAndPassword(String username, String pswd) throws Exception;

	void insertData(Users usr) throws Exception;
}
