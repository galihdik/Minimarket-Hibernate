package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Roles;

/**
 *
 * @author Galih Dika
 *
 */

public interface RolesService {
	public List<Roles> getRoles() throws Exception;

	public void addData(Roles rl) throws Exception;

	public Roles getRolesByCode(String code) throws Exception;
}
