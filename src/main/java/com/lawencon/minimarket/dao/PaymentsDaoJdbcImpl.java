package com.lawencon.minimarket.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Payments;

/**
 *
 * @author Galih Dika
 *
 */

public class PaymentsDaoJdbcImpl extends BaseDao implements PaymentsDao {
	@Override
	public Payments getPaymentsType(String payment) throws Exception {
		String sql = "select payments_type from tb_m_payments where name_payments = ?";
		Object[] params = new Object[] { payment };
		int[] types = new int[] { Types.VARCHAR };
		Payments pym = getJdbcTemplate().queryForObject(sql, params, types, (rs, ro) -> {
			Payments py = new Payments();
			py.setIdPayments(rs.getLong("id_payments"));
			py.setPaymentsType(rs.getString("payments_type"));
			return py;
		});
		return pym;
	}

	@Override
	public List<Payments> getListPayments() throws Exception {
		List<Payments> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_payments";
		listResult = getJdbcTemplate().query(sql, (rs, ro) -> {
			Payments py = new Payments();
			py.setIdPayments(rs.getLong("id_payments"));
			py.setNamePayments(rs.getString("name_payments"));
			py.setPaymentsType(rs.getString("payments_type"));
			return py;
		});
		return listResult;
	}

	@Override
	public void insertData(Payments py) throws Exception {
		String sql = "insert into tb_m_payments (name_payments,payments_type,payment_code)" + " values (? , ? ,?) ";
		Object[] params = new Object[] { py.getNamePayments(), py.getPaymentsType(), py.getPaymentCode() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		getJdbcTemplate().update(sql, params, types);
	}
}
