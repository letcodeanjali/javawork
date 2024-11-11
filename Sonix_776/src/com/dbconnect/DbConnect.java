package com.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbConnect {

	public static void main(String[] args)throws Exception {
		 String jdbcURL = "jdbc:mysql://localhost:3306/health?useLegacyDatetimeCode=false&serverTimezone=UTC";
	        String username = "root";
	        String password = "Paddu@8035";
	        Connection con = DriverManager.getConnection(jdbcURL, username, password); 
	        String SQL = "SELECT DOC_ID, DNAME,GENDER, QUALIFICATION, JOB_SPECIFICATION, HOSP_NAME, EXP FROM doctor";
	        PreparedStatement ps = con.prepareStatement(SQL);
	        ResultSet rs=ps.executeQuery();
	        while(rs.next()) {
        		int did=rs.getInt("DOC_ID");
        		String dname = rs.getString("DNAME");
                String gen = rs.getString("GENDER");
                String q = rs.getString("QUALIFICATION");
                String spec = rs.getString("JOB_SPECIFICATION");
                String hname = rs.getString("HOSP_NAME");
                int dexp = rs.getInt("EXP");
                System.out.println(did+" "+dname+" "+gen+" "+q+" "+spec+" "+hname+" "+dexp);
        	}
	        con.close();
	        
	}
}
