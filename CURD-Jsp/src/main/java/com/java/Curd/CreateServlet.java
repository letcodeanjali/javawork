package com.java.Curd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String dateOfBirth = request.getParameter("DateOfBirth");
		String gender = request.getParameter("Gender");
		String phoneNumber = request.getParameter("PhoneNumber");
		String address = request.getParameter("Address");

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crimereport", "root", "Anjali@123");
			String sql = "INSERT INTO Victims (FirstName, LastName, DateOfBirth, Gender, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, dateOfBirth);
			ps.setString(4, gender);
			ps.setString(5, phoneNumber);
			ps.setString(6, address);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			log("JDBC Driver not found", e);
		} catch (SQLException e) {
			log("Error executing SQL", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log("Error closing resources", e);
			}
		}
		response.sendRedirect("read.jsp");
	}

	@Override
	public void log(String message, Throwable throwable) {
		super.log(message, throwable);
		throwable.printStackTrace(); // Log to console
	}
}
