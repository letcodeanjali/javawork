package com.java.curdjpa;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	private static final String URL = "jdbc:mysql://localhost:3306/crimereport";
	private static final String USER = "your_username";
	private static final String PASSWORD = "your_password";

	public static java.sql.Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
