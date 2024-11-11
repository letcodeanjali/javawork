package com.AgentJdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AgentShow {
	
	    public static void main(String[] args) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "Anjali@123");
	            System.out.println("Connected to the database.");
	            String cmd = "SELECT * FROM Agent";
	            Statement st = connection.createStatement();
	            ResultSet rs = st.executeQuery(cmd);
	            while (rs.next()) {
	                System.out.println("Agent ID: " + rs.getInt("AgentID"));
	                System.out.println("Name: " + rs.getString("Name"));
	                System.out.println("Gender: " + rs.getString("GENDER"));
	                System.out.println("City: " + rs.getString("City"));
	                System.out.println("Marital Status: " + rs.getInt("MaritalStatus"));
	                System.out.println("Premium: " + rs.getDouble("Premium"));
	                System.out.println("----------------");
	            }
	            // Close resources
	            rs.close();
	            st.close();
	            connection.close();
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



