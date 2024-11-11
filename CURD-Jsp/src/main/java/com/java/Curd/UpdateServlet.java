package com.java.Curd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int victimID = Integer.parseInt(request.getParameter("VictimID"));
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		String dateOfBirth = request.getParameter("DateOfBirth");
		String gender = request.getParameter("Gender");
		String phoneNumber = request.getParameter("PhoneNumber");
		String address = request.getParameter("Address");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crimereport", "root",
					"password");
			String sql = "UPDATE Victims SET FirstName = ?, LastName = ?, DateOfBirth = ?, Gender = ?, PhoneNumber = ?, Address = ? WHERE VictimID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, dateOfBirth);
			ps.setString(4, gender);
			ps.setString(5, phoneNumber);
			ps.setString(6, address);
			ps.setInt(7, victimID);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("read.jsp");
	}
}
