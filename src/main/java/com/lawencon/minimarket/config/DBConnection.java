package com.lawencon.minimarket.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Galih Dika
 *
 */

public class DBConnection {
	public static void main(String[] args) {
		new DBConnection().conn();

	}

	public Connection conn() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/minimarket",
					"postgres", "postgres");
			// System.out.println("Database connected");
			return connection;
		} catch (Exception e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
		return null;
	}
}
