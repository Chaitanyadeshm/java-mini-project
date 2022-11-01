package com.cybage.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtility {
	private static Connection connection = null;

	public static Connection getConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/miniprojecttwo";
		String username = "root";
		String password = "root";
		// By writing the connection code inside the try block we are using the concept of 
		// Automatic Resource Management (ARM) so that we do not have to explicitly close the 
		// connection
		try  {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeConnection() throws SQLException {
		connection.close();
	}

}
