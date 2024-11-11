package com.java.Curd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Victim> victims = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Victims", "root", "Anjali@123");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Victims");

			while (rs.next()) {
				Victim victim = new Victim();
				victim.setFirstName(rs.getString("FirstName"));
				victim.setLastName(rs.getString("LastName"));
				victim.setDateOfBirth(rs.getString("DateOfBirth"));
				victim.setGender(rs.getString("Gender"));
				victim.setPhoneNumber(rs.getString("PhoneNumber"));
				victim.setAddress(rs.getString("Address"));
				victims.add(victim);
			}

			request.setAttribute("victims", victims);
			RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
