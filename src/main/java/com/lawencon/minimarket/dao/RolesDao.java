package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Roles;

/**
 *
 * @author Galih Dika
 *
 */

public interface RolesDao {
	List<Roles> getListRoles() throws Exception;

	void insertData(Roles rl) throws Exception;

	public Roles getRolesByCode(String roles) throws Exception;
}
