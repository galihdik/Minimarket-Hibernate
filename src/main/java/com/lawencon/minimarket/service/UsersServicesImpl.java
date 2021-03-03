package com.lawencon.minimarket.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.minimarket.dao.UsersDao;
import com.lawencon.minimarket.model.UserSessionCache;
import com.lawencon.minimarket.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public class UsersServicesImpl extends BaseService implements UsersServices {
	private UsersDao usrDao;
	private UserSessionCache usrCache;
	private TransactionTemplate transactionTemplate;

	public UsersServicesImpl(UsersDao usrDao, UserSessionCache usrCache, TransactionTemplate transactionTemplate) {
		this.usrDao = usrDao;
		this.usrCache = usrCache;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public Users loginUsernamePassword(String username, String pswd) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				Users usr = usrDao.getUsersByUsernameAndPassword(username, pswd);
				usrCache.setActiveUser(usr);
				return usrDao.getUsersByUsernameAndPassword(username, pswd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public List<Users> getUser() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				usrDao.getListUsers();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(Users usr) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				usrDao.insertData(usr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

	}
}