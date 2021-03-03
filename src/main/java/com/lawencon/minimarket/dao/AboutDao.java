package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.About;

/**
 *
 * @author Galih Dika
 *
 */

public interface AboutDao {
	List<About> getListAbout() throws Exception;

	void insertData(About about) throws Exception;

	public About getAboutByCode(String code) throws Exception;
}
