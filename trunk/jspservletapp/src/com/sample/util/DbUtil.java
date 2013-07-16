package com.sample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static final String DB_DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/UserDB";
	public static final String DB_USER_NAME = "admin";
	public static final String DB_PASSWORD = "test";

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName(DB_DRIVER_NAME);
				connection = DriverManager.getConnection(DB_URL, DB_USER_NAME,
						DB_PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}
}
