package com.lawencon.minimarket.dao;

import java.util.List;

import com.lawencon.minimarket.model.Roles;

/**
 *
 * @author Galih Dika
 *
 */

public class RolesDaoHibernateImpl extends BaseDao implements RolesDao {

	@Override
	public List<Roles> getListRoles() throws Exception {
		List<Roles> listResult = getSession().createQuery("from Roles", Roles.class).list();
		return listResult;
	}

	@Override
	public void insertData(Roles rl) throws Exception {
		getSession().persist(rl);
	}

	@Override
	public Roles getRolesByCode(String roles) throws Exception {
		List<Roles> listResult = getSession().createQuery("from Roles where codeRoles = ?1", Roles.class)
				.setParameter(1, roles).list();
		return listResult.size() > 0 ? listResult.get(0) : null;
	}

}
