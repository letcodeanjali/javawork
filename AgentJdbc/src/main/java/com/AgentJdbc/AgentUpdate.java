package com.AgentJdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class AgentUpdate {
	
	    public static void main(String[] args) {
	        int agentId;
	        double premium;
	        String name, gender, city;
	        int maritalStatus;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Agent ID: ");
	        agentId = sc.nextInt();
	        System.out.println("Enter Name: ");
	        name = sc.next();
	        System.out.println("Enter Gender (MALE/FEMALE): ");
	        gender = sc.next();
	        System.out.println("Enter City: ");
	        city = sc.next();
	        System.out.println("Enter Marital Status (0 for Single, 1 for Married): ");
	        maritalStatus = sc.nextInt();
	        System.out.println("Enter Premium: ");
	        premium = sc.nextDouble();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "Anjali@123");
	            String cmd = "UPDATE Agent SET Name = ?, GENDER = ?, City = ?, MaritalStatus = ?, Premium = ? WHERE AgentID = ?";
	            PreparedStatement pst = connection.prepareStatement(cmd);
	            pst.setString(1, name);
	            pst.setString(2, gender);
	            pst.setString(3, city);
	            pst.setInt(4, maritalStatus);
	            pst.setDouble(5, premium);
	            pst.setInt(6, agentId);
	            pst.executeUpdate();
	            System.out.println("*** Record Updated ***");
	            // Close resources
	            pst.close();
	            connection.close();
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



