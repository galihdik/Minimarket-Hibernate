package com.lawencon.minimarket.dao;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.About;
import com.lawencon.minimarket.model.Payments;
import com.lawencon.minimarket.model.Transactions;
import com.lawencon.minimarket.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public class TransactionsDaoJdbcImpl extends BaseDao implements TransactionsDao {
	@Override
	public List<Transactions> getListTransactions() throws Exception {
		List<Transactions> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_r_hdr_transaction";
		listResult = getJdbcTemplate().query(sql, (rs, ro) -> {
			Transactions tr = new Transactions();
			tr.setIdTransaction(rs.getLong("id_transaction"));
			tr.setTransactionDate(rs.getObject("transaction_date", LocalDateTime.class));
			tr.setPriceTotal(rs.getBigDecimal("price_total"));

			About ab = new About();
			ab.setIdAbout(rs.getLong("id_about"));
			Payments py = new Payments();
			py.setIdPayments(rs.getLong("id_payments"));
			Users us = new Users();
			us.setUserId(rs.getLong("id_users"));
			tr.setIdAbout(ab);
			tr.setIdPayments(py);
			tr.setIdUsers(us);
			tr.setStrukCode(rs.getString("struk_code"));
			return tr;
		});
		return listResult;
	}

	@Override
	public Transactions insertData(Transactions transaction) throws Exception {
		String sql = bBuilder(
				"insert into tb_r_hdr_transaction (transaction_date ,price_total, id_about , id_payments , id_users, struk_code)",
				" values (current_timestamp ,?, 7, (select id_payments from tb_m_payments where name_payments = ? ) , (select user_id from tb_m_users where username = ? ) , ?) returning id_transaction,transaction_date ,price_total, id_about , id_payments , id_users, struk_code")
						.toString();
		Object[] params = new Object[] { transaction.getPriceTotal(), transaction.getIdPayments().getPaymentsType(),
				transaction.getIdUsers().getUsername(), transaction.getStrukCode() };
		int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		Transactions trx = getJdbcTemplate().queryForObject(sql, params, types, (rs, ro) -> {
			Transactions tr = new Transactions();
			tr.setIdTransaction(rs.getLong("id_transaction"));
			tr.setTransactionDate(rs.getObject("transaction_date", LocalDateTime.class));
			tr.setPriceTotal(rs.getBigDecimal("price_total"));

			About ab = new About();
			ab.setIdAbout(rs.getLong("id_about"));
			Payments py = new Payments();
			py.setIdPayments(rs.getLong("id_payments"));
			Users us = new Users();
			us.setUserId(rs.getLong("id_users"));
			tr.setIdAbout(ab);
			tr.setIdPayments(py);
			tr.setIdUsers(us);
			tr.setStrukCode(rs.getString("struk_code"));
			return tr;
		});
		return trx;
	}

	@Override
	public void updateData(Transactions transaction) throws Exception {
		String sql = bBuilder("update tb_r_hdr_transaction h ", "set price_total = (select sum(price) ",
				"from tb_r_dtl_transaction d ", "group by d.id_transaction ", "having d.id_transaction = ?) ",
				"where id_transaction = ? ").toString();
		Object[] params = new Object[] { transaction.getIdTransaction(), transaction.getIdTransaction() };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER };
		getJdbcTemplate().update(sql, params, types);
	}
}
