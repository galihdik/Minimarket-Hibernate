package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public interface UsersServices {

	public Users loginUsernamePassword(String username, String pswd) throws Exception;

	public List<Users> getUser() throws Exception;

	public void addData(Users usr) throws Exception;
}
