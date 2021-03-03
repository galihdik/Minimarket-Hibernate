package com.lawencon.minimarket.dao;

import java.math.BigDecimal;
import java.sql.Types;
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

public class DetailTransactionDaoJdbcImpl extends BaseDao implements DetailTransactionDao {
	@Override
	public List<DetailTransactions> getListDetailTransactions() throws Exception {
		List<DetailTransactions> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_r_dtl_transaction";
		listResult = getJdbcTemplate().query(sql, (rs, ro) -> {
			DetailTransactions tr = new DetailTransactions();
			tr.setIdDetailTransaction(rs.getLong("id_detail_transaction"));
			tr.setQty(rs.getInt("qty"));
			Items it = new Items();
			it.setIdItems(rs.getLong("id_item"));
			tr.setIdItems(it);
			Transactions trx = new Transactions();
			trx.setIdTransaction(rs.getLong("id_transaction"));
			tr.setIdTransaction(trx);
			return tr;
		});
		return listResult;
	}

	@Override
	public void insert(DetailTransactions trx, Transactions idTransaction) throws Exception {
		String sql = bBuilder("insert into tb_r_dtl_transaction (qty, price ,id_item , id_transaction) values ",
				"(?, ? , (select id_item from tb_m_items where code_items = ?), ?)").toString();
		BigDecimal tampungHarga = BigDecimal.ZERO;
		Object[] params = new Object[] { trx.getQty(),
				trx.getIdItems().getPriceItems().multiply(tampungHarga.valueOf(trx.getQty())),
				trx.getIdItems().getCodeItems(), idTransaction.getIdTransaction() };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.INTEGER };
		getJdbcTemplate().update(sql, params, types);
	}
}
