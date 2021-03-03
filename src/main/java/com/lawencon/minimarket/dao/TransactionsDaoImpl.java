package com.lawencon.minimarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

public class TransactionsDaoImpl extends BaseDao implements TransactionsDao {

	@Override
	public List<Transactions> getListTransactions() throws Exception {
		List<Transactions> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_r_hdr_transaction");
		while (rs.next()) {
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
			listResult.add(tr);
		}
		return listResult;
	}

	@Override
	public Transactions insertData(Transactions transaction) throws Exception {
		String sql = bBuilder(
				"insert into tb_r_hdr_transaction (transaction_date ,price_total, id_about , id_payments , id_users, struk_code)",
				" values (current_timestamp ,?, 7, (select id_payments from tb_m_payments where name_payments = ? ) , (select user_id from tb_m_users where user_code = ? ) , ?) returning id_transaction,price_total")
						.toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setBigDecimal(1, transaction.getPriceTotal());
		ps.setString(2, transaction.getIdPayments().getPaymentsType());
		ps.setString(3, transaction.getIdUsers().getUserCode());
		ps.setString(4, transaction.getStrukCode());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			transaction.setIdTransaction(rs.getLong("id_transaction"));
			transaction.setPriceTotal(rs.getBigDecimal("price_total"));
			break;
		}
		return transaction;
	}

	@Override
	public void updateData(Transactions transaction) throws Exception {
		String sql = bBuilder("update tb_r_hdr_transaction h ", "set price_total = (select sum(price) ",
				"from tb_r_dtl_transaction d ", "group by d.id_transaction ", "having d.id_transaction = ?) ",
				"where id_transaction = ? ", "returning id_transaction").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setLong(1, transaction.getIdTransaction());
		ps.setLong(2, transaction.getIdTransaction());
		ResultSet rs = ps.executeQuery();
	}

}
