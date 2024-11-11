package com.AgentJdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AgentSearch {
	

	
	    public static void main(String[] args) {
	        int agentId;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Agent ID: ");
	        agentId = sc.nextInt();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "Anjali@123");
	            String cmd = "SELECT * FROM Agent WHERE AgentID = ?";
	            PreparedStatement pst = connection.prepareStatement(cmd);
	            pst.setInt(1, agentId);
	            ResultSet rs = pst.executeQuery();
	            if (rs.next()) {
	                System.out.println("Agent ID: " + rs.getInt("AgentID"));
	                System.out.println("Name: " + rs.getString("Name"));
	                System.out.println("City: " + rs.getString("City"));
	                System.out.println("Gender: " + rs.getString("GENDER"));
	                System.out.println("Marital Status: " + rs.getInt("MaritalStatus"));
	                System.out.println("Premium: " + rs.getDouble("Premium"));
	            } else {
	                System.out.println("*** Record Not Found ***");
	            }
	            // Close resources
	            rs.close();
	            pst.close();
	            connection.close();
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



