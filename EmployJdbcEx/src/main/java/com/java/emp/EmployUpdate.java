package com.java.emp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployUpdate {
	public static void main(String[] args) {
		int empno, basic;
		String name, gender, dept, desig;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employ Number   ");
		empno = sc.nextInt();
		System.out.println("Enter Name   ");
		name = sc.next();
		System.out.println("Enter Gender   ");
		gender = sc.next();
		System.out.println("Enter Department  ");
		dept = sc.next();
		System.out.println("Enter Designation  ");
		desig = sc.next();
		System.out.println("Enter Basic  ");
		basic = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonixpractice", 
					"root", "Anjali@123");
			String cmd = "Update Employ set Name = ?, Gender = ?, Dept = ?, Desig = ?, "
					+ " Basic = ? Where Empno = ?";
			PreparedStatement pst = connnection.prepareStatement(cmd);
			pst.setString(1, name);
			pst.setString(2, gender);
			pst.setString(3, dept);
			pst.setString(4, desig);
			pst.setInt(5, basic);
			pst.setInt(6, empno);
			pst.executeUpdate();
			System.out.println("*** Record Updated ***");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
