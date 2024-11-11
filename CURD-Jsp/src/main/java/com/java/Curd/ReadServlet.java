package com.java.Curd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crimereport", "root",
					"Anjali@123");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Victims");

			response.getWriter().println(
					"<table border='1'><tr><th>VictimID</th><th>First Name</th><th>Last Name</th><th>Date of Birth</th><th>Gender</th><th>Phone Number</th><th>Address</th></tr>");
			while (rs.next()) {
				response.getWriter()
						.println("<tr><td>" + rs.getInt("VictimID") + "</td><td>" + rs.getString("FirstName")
								+ "</td><td>" + rs.getString("LastName") + "</td><td>" + rs.getDate("DateOfBirth")
								+ "</td><td>" + rs.getString("Gender") + "</td><td>" + rs.getString("PhoneNumber")
								+ "</td><td>" + rs.getString("Address") + "</td></tr>");
			}
			response.getWriter().println("</table>");

			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
