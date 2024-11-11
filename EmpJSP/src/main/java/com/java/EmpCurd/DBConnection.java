package com.java.EmpCurd;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

public class DBConnection {

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		} else {
			try {
				Properties prop = new Properties();
				InputStream input = new FileInputStream("database.properties");
				prop.load(input);

				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");

				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);

				return connection;

			} catch (IOException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return null; // Or handle the exception according to your application's requirements
			}
		}
	}
}
