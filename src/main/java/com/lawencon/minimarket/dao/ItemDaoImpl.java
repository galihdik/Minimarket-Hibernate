package com.lawencon.minimarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

public class ItemDaoImpl extends BaseDao implements ItemDao {
	@Override
	public Items getItemByCode(String code) throws Exception {
		Items i = new Items();
		String sql = "select * from tb_m_items i where i.code_items = ?";
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, code);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			i.setIdItems(rs.getLong("id_item"));
			i.setNameItems(rs.getString("name_item"));
			i.setPriceItems(rs.getBigDecimal("price_item"));
			i.setExpiredItems(rs.getTimestamp("expired_items").toLocalDateTime());
			i.setStockItems(rs.getInt("stock_items"));
			i.setCodeItems(rs.getString("code_items"));
			Supliers sp = new Supliers();
			sp.setIdSupliers(rs.getLong("id_supliers"));
			Category ct = new Category();
			ct.setIdCategory(rs.getLong("id_category"));
			i.setIdSupliers(sp);
			i.setIdCategory(ct);
			break;
		}
		return i;
	}

	@Override
	public List<Items> getListItem() throws Exception {
		List<Items> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_m_items");
		while (rs.next()) {
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
			listResult.add(item);
		}
		return listResult;
	}

	@Override
	public void insertData(Items item) throws Exception {
		String sql = bBuilder(
				"insert into tb_m_items (name_item,expired_items,stock_items,price_item,id_supliers,id_category,code_items)",
				" values (? , ? , ? , ? , ? , ? , ?) ").toString();
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, item.getNameItems());
		ps.setObject(2, item.getExpiredItems());
		ps.setInt(3, item.getStockItems());
		ps.setBigDecimal(4, item.getPriceItems());
		ps.setLong(5, item.getIdSupliers().getIdSupliers());
		ps.setLong(6, item.getIdCategory().getIdCategory());
		ps.setString(7, item.getCodeItems());
		ps.executeUpdate();

	}

}
