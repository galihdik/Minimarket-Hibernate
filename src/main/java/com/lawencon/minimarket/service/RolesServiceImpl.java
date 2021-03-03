package com.lawencon.minimarket.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.minimarket.dao.RolesDao;
import com.lawencon.minimarket.model.Roles;

/**
 *
 * @author Galih Dika
 *
 */

public class RolesServiceImpl extends BaseService implements RolesService {
	private RolesDao rolesDao;
	private TransactionTemplate transactionTemplate;

	public RolesServiceImpl(RolesDao rolesDao, TransactionTemplate transactionTemplate) {
		this.rolesDao = rolesDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Roles> getRoles() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				rolesDao.getListRoles();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(Roles rl) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				rolesDao.insertData(rl);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public Roles getRolesByCode(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return rolesDao.getRolesByCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

	}
}
