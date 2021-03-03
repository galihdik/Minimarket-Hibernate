package com.lawencon.minimarket.service;

import java.util.List;

import com.lawencon.minimarket.model.About;

/**
 *
 * @author Galih Dika
 *
 */

public interface AboutService {
	public List<About> getAbout() throws Exception;

	public void addData(About about) throws Exception;

	public About getAboutByCode(String code) throws Exception;
}
