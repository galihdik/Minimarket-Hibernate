package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.About;

/**
 *
 * @author Galih Dika
 *
 */

public class AboutDaoHibernateImpl extends BaseDao implements AboutDao {

	@Override
	public List<About> getListAbout() throws Exception {
		List<About> listResult = getSession().createQuery("from About", About.class).list();
		return listResult;

	}

	@Override
	public void insertData(About about) throws Exception {
		// getTransactionTemplate().executeWithoutResult(val -> {
		getSession().persist(about);
		// });
	}

	@Override
	public About getAboutByCode(String code) throws Exception {
		// List<About> listResult = getTransactionTemplate().execute(val -> {
		List<About> listResult = getSession().createQuery("from About where aboutCode = ?1", About.class)
				.setParameter(1, code).list();
		// });
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

}
