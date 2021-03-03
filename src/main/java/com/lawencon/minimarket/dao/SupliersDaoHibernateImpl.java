package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Supliers;

/**
 *
 * @author Galih Dika
 *
 */

public class SupliersDaoHibernateImpl extends BaseDao implements SupliersDao {

	@Override
	public List<Supliers> getListSuplier() throws Exception {
		List<Supliers> listResult = getSession().createQuery("from Supliers", Supliers.class).list();
		return listResult;
	}

	@Override
	public void insertData(Supliers spl) throws Exception {
		getSession().persist(spl);
	}

	@Override
	public Supliers getSupliersByCode(String suplier) throws Exception {
		List<Supliers> listResult = getSession().createQuery("from Supliers where suplierCode = ?1", Supliers.class)
				.setParameter(1, suplier).list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

}
