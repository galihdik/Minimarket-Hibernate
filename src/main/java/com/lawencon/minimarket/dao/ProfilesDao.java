package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public interface ProfilesDao {
	List<Profiles> getListProfile() throws Exception;

	void insertData(Profiles prf) throws Exception;

	public Profiles getProfilesByCode(String profile) throws Exception;
}
