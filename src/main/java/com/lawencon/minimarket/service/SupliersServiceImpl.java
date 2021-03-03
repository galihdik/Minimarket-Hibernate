package com.lawencon.minimarket.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.minimarket.dao.SupliersDao;
import com.lawencon.minimarket.model.Supliers;

/**
 *
 * @author Galih Dika
 *
 */

public class SupliersServiceImpl extends BaseService implements SupliersService {
	private SupliersDao supliersDao;
	private TransactionTemplate transactionTemplate;

	public SupliersServiceImpl(SupliersDao supliersDao, TransactionTemplate transactionTemplate) {
		this.supliersDao = supliersDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Supliers> getSupliers() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				supliersDao.getListSuplier();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(Supliers sp) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				supliersDao.insertData(sp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public Supliers getSupliersByCode(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return supliersDao.getSupliersByCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

	}

}
