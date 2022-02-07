package com.tectoro.user.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDb {
	private static Connection connection = null;
	
	public static Connection userDb() throws ClassNotFoundException, SQLException {
		if (connection == null || connection.isClosed()) {
			String url = "jdbc:mysql://localhost:3306/naresh";
			String userName = "root";
			String password = "S@tya33N";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Hello db");
		}
				
		return connection;
	}
	public static void closeConnection(Connection conn) {

		try {
			connection.close();
		} catch (SQLException e) {

		}
	}

}
