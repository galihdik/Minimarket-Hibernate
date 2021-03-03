package com.lawencon.minimarket.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.minimarket.dao.ItemDao;
import com.lawencon.minimarket.model.Items;

/**
 *
 * @author Galih Dika
 *
 */

public class ItemServiceImpl extends BaseService implements ItemService {
	private ItemDao daoItem;
	private TransactionTemplate transactionTemplate;

	public ItemServiceImpl(ItemDao daoItem, TransactionTemplate transactionTemplate) {
		this.daoItem = daoItem;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public Items getItemByCode(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return daoItem.getItemByCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public List<Items> getItem() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				daoItem.getListItem();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void insertData(Items item) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				daoItem.insertData(item);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

}