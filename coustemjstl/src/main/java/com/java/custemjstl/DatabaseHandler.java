package com.java.custemjstl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

public class DatabaseHandler extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonixpractice", "root", "root");
			String cmd = "select * from Employ";
			PreparedStatement pst = conn.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			List<Employ> employList = new ArrayList<Employ>();
			while(rs.next()) {
				Employ employ = new Employ();
				employ.setEmpno(rs.getInt("empno"));
				employ.setName(rs.getString("name"));
				employ.setGender(rs.getString("gender"));
				employ.setDept(rs.getString("dept"));
				employ.setDesig(rs.getString("desig"));
				employ.setBasic(rs.getDouble("basic"));
				employList.add(employ);
			}
			JspWriter out = pageContext.getOut();
			for (Employ employ : employList) {
				out.println(employ);
				out.println("<br/>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
}
