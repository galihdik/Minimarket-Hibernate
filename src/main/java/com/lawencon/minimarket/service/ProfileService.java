package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public interface ProfileService {
	public List<Profiles> getProfile() throws Exception;

	public void addData(Profiles prf) throws Exception;

	public Profiles getProfilesByCode(String code) throws Exception;
}
