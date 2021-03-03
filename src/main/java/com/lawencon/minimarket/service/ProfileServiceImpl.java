
package com.lawencon.minimarket.service;

import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.minimarket.dao.ProfilesDao;
import com.lawencon.minimarket.model.Profiles;

/**
 *
 * @author Galih Dika
 *
 */

public class ProfileServiceImpl extends BaseService implements ProfileService {
	private ProfilesDao profileDao;
	private TransactionTemplate transactionTemplate;

	public ProfileServiceImpl(ProfilesDao profileDao, TransactionTemplate transactionTemplate) {
		this.profileDao = profileDao;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Profiles> getProfile() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				profileDao.getListProfile();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(Profiles prf) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				profileDao.insertData(prf);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public Profiles getProfilesByCode(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return profileDao.getProfilesByCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

	}

}
