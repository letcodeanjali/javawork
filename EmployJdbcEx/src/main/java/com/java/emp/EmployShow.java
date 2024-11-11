package com.java.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployShow {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonixpractice","root","Anjali@123");
            System.out.println("Connected to the database.");
            String cmd = "SELECT * FROM Employ";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(cmd);
            while (rs.next()) {
                System.out.println("Employ no: " + rs.getInt("empno"));
                System.out.println("EmployName:"+rs.getString("name"));
                System.out.println("Gender"+rs.getString("gender"));
                System.out.println("Depertment"+rs.getString("dept"));
                System.out.println("Designation"+rs.getString("desig"));
                System.out.println("Depertment"+rs.getString("dept"));
                System.out.println("Basic"+rs.getDouble("basic"));
                System.out.println("----------------");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
