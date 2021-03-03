package com.lawencon.minimarket.dao;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Category;
import com.lawencon.minimarket.model.Items;
import com.lawencon.minimarket.model.Supliers;

/**
 *
 * @author Galih Dika
 *
 */

public class ItemDaoJdbcImpl extends BaseDao implements ItemDao {

	@Override
	public Items getItemByCode(String code) throws Exception {
		String sql = "select * from tb_m_items i where i.code_items = ?";
		Object[] params = new Object[] { code };
		int[] types = new int[] { Types.VARCHAR };
		Items i = getJdbcTemplate().queryForObject(sql, params, types, (rs, ro) -> {
			Items it = new Items();
			it.setIdItems(rs.getLong("id_item"));
			it.setNameItems(rs.getString("name_item"));
			it.setPriceItems(rs.getBigDecimal("price_item"));
			it.setExpiredItems(rs.getTimestamp("expired_items").toLocalDateTime());
			it.setStockItems(rs.getInt("stock_items"));
			it.setCodeItems(rs.getString("code_items"));
			Supliers sp = new Supliers();
			sp.setIdSupliers(rs.getLong("id_supliers"));
			Category ct = new Category();
			ct.setIdCategory(rs.getLong("id_category"));
			it.setIdSupliers(sp);
			it.setIdCategory(ct);
			return it;
		});
		return i;
	}

	@Override
	public List<Items> getListItem() throws Exception {
		List<Items> listResult = new ArrayList<>();
		String sql = "SELECT * FROM tb_m_items";
		listResult = getJdbcTemplate().query(sql, (rs, ro) -> {
			Items item = new Items();
			item.setIdItems(rs.getLong("id_item"));
			item.setNameItems(rs.getString("name_item"));
			item.setExpiredItems(rs.getObject("expired_items", LocalDateTime.class));
			item.setStockItems(rs.getInt("stock_items"));
			item.setPriceItems(rs.getBigDecimal("price_item"));
			Supliers sp = new Supliers();
			sp.setIdSupliers(rs.getLong("id_supliers"));
			item.setIdSupliers(sp);
			Category ct = new Category();
			ct.setIdCategory(rs.getLong("id_category"));
			item.setIdCategory(ct);
			item.setCodeItems(rs.getString("code_items"));
			return item;
		});
		return listResult;
	}

	@Override
	public void insertData(Items item) throws Exception {
		String sql = bBuilder(
				"insert into tb_m_items (name_item,expired_items,stock_items,price_item,id_supliers,id_category,code_items)",
				" values (? , ? , ? , ? , ? , ? , ?) ").toString();
		Object[] params = new Object[] { item.getNameItems(), item.getExpiredItems(), item.getStockItems(),
				item.getPriceItems(), item.getIdSupliers().getIdSupliers(), item.getIdCategory().getIdCategory(),
				item.getCodeItems() };
		int[] types = new int[] { Types.VARCHAR, Types.TIMESTAMP, Types.INTEGER, Types.INTEGER, Types.INTEGER,
				Types.INTEGER, Types.VARCHAR };
		getJdbcTemplate().update(sql, params, types);
	}
}
