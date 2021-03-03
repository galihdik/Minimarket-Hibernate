package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Items;

/**
 *
 * @author Galih Dika
 *
 */

public class ItemDaoHibernateImpl extends BaseDao implements ItemDao {

	@Override
	public Items getItemByCode(String code) throws Exception {
		List<Items> listResult = getSession().createQuery("from Items where codeItems = ?1", Items.class)
				.setParameter(1, code).list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public List<Items> getListItem() throws Exception {
		List<Items> listResult = getSession().createQuery("from Items", Items.class).list();
		return listResult;
	}

	@Override
	public void insertData(Items item) throws Exception {
		getSession().persist(item);
	}

}
