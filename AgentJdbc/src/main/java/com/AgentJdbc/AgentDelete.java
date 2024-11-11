package com.AgentJdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentDelete {
	

	
	    public static void main(String[] args) {
	        int agentId;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Agent ID: ");
	        agentId = sc.nextInt();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "Anjali@123");
	            String cmd = "DELETE FROM Agent WHERE AgentID = ?";
	            PreparedStatement pst = connection.prepareStatement(cmd);
	            pst.setInt(1, agentId);
	            int rowsAffected = pst.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("*** Record Deleted ***");
	            } else {
	                System.out.println("*** Record Not Found ***");
	            }
	            // Close resources
	            pst.close();
	            connection.close();
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



