package com.lawencon.minimarket.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lawencon.minimarket.model.Payments;

/**
 *
 * @author Galih Dika
 *
 */

public class PaymentsDaoImpl extends BaseDao implements PaymentsDao {
	@Override
	public Payments getPaymentsType(String payment) throws Exception {
		Payments p = new Payments();
		String sql = "select payments_type from tb_m_payments where name_payments = ?";
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, payment);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			p.setIdPayments(rs.getLong("id_payments"));
			p.setPaymentsType(rs.getString("payments_type"));
			return p;
		}
		return null;
	}

	@Override
	public List<Payments> getListPayments() throws Exception {
		List<Payments> listResult = new ArrayList<>();
		Statement statement = conn().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM tb_m_payments");
		while (rs.next()) {
			Payments py = new Payments();
			py.setIdPayments(rs.getLong("id_payments"));
			py.setNamePayments(rs.getString("name_payments"));
			py.setPaymentsType(rs.getString("payments_type"));
			listResult.add(py);
		}
		return listResult;
	}

	@Override
	public void insertData(Payments py) throws Exception {
		String sql = "insert into tb_m_payments (name_payments,payments_type,payment_code)" + " values (? , ? ,?) ";
		PreparedStatement ps = conn().prepareStatement(sql);
		ps.setString(1, py.getNamePayments());
		ps.setString(2, py.getPaymentsType());
		ps.setString(3, py.getPaymentCode());
		ps.executeUpdate();
	}

}
