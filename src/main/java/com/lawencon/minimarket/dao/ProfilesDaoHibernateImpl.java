package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public class ProfilesDaoHibernateImpl extends BaseDao implements ProfilesDao {

	@Override
	public List<Profiles> getListProfile() throws Exception {
		List<Profiles> listResult = getSession().createQuery("from Profiles", Profiles.class).list();
		return listResult;
	}

	@Override
	public void insertData(Profiles prf) throws Exception {
		getSession().persist(prf);
	}

	@Override
	public Profiles getProfilesByCode(String profile) throws Exception {
		List<Profiles> listResult = getSession().createQuery("from Profiles where profileCode = ?1", Profiles.class)
				.setParameter(1, profile).list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}
}
