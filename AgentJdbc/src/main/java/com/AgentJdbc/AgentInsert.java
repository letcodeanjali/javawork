package com.AgentJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AgentInsert {
    public static void main(String[] args) {
        int AgentId;
        double Premium;
        String name, gender, city;
        int maritalStatus;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Agent ID: ");
        AgentId = sc.nextInt();
        System.out.println("Enter Name: ");
        name = sc.next();
        System.out.println("Enter Gender (MALE/FEMALE): ");
        gender = sc.next();
        System.out.println("Enter City: ");
        city = sc.next();
        System.out.println("Enter Marital Status (0 for Single, 1 for Married): ");
        maritalStatus = sc.nextInt();
        System.out.println("Enter Premium: ");
        Premium = sc.nextDouble();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam",
                    "root", "Anjali@123");
            String cmd = "INSERT INTO Agent (Name, City, Gender, MaritalStatus, Premium) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(cmd);
            pst.setString(1, name);
            pst.setString(2, city);
            pst.setString(3, gender);
            pst.setInt(4, maritalStatus);
            pst.setDouble(5, Premium);
            pst.executeUpdate();
            System.out.println("*** Record Inserted ***");

            // Close resources
            pst.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
