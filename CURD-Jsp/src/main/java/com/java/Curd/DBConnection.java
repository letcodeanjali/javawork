package com.java.Curd;

//DBConnection.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/crimereport";
	private static String jdbcUsername = "root"; // Update with your MySQL username
	private static String jdbcPassword = "Anjali@123"; // Update with your MySQL password

	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
