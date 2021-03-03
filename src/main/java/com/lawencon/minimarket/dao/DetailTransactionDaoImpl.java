package com.lawencon.minimarket.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.DetailTransactions;
import com.lawencon.minimarket.model.Items;
import com.lawencon.minimarket.model.Transactions;

/**
 *
 * @author Galih Dika
 *
 */

public class DetailTransactionDaoImpl extends BaseDao implements DetailTransactionDao {
	@Override
	public List<DetailTransactions> getListDetailTransactions() throws Exception {
		List<DetailTransactions> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_r_dtl_transaction");
		while (rs.next()) {
			DetailTransactions tr = new DetailTransactions();
			tr.setIdDetailTransaction(rs.getLong("id_detail_transaction"));
			tr.setQty(rs.getInt("qty"));
			Items it = new Items();
			it.setIdItems(rs.getLong("id_item"));
			tr.setIdItems(it);
			Transactions trx = new Transactions();
			trx.setIdTransaction(rs.getLong("id_transaction"));
			tr.setIdTransaction(trx);
			listResult.add(tr);
		}
		return listResult;
	}

	@Override
	public void insert(DetailTransactions trx, Transactions idTransaction) throws Exception {
		String sql = bBuilder("insert into tb_r_dtl_transaction (qty, price ,id_item , id_transaction) values ",
				"(?, ? , (select id_item from tb_m_items where code_items = ?), ?)").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		BigDecimal tamp = BigDecimal.ZERO;
		ps.setInt(1, trx.getQty());
		ps.setBigDecimal(2, trx.getIdItems().getPriceItems().multiply(tamp.valueOf(trx.getQty())));
		ps.setString(3, trx.getIdItems().getCodeItems());
		ps.setLong(4, idTransaction.getIdTransaction());
		ps.executeUpdate();
	}
}