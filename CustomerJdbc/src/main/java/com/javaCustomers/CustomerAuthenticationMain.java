package com.javaCustomers;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerAuthenticationMain {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Username:");
        String username = sc.nextLine();

        System.out.println("Enter Password:");
        String password = sc.nextLine();

        CustomerDao dao = new CustomerDaoImpl();
        try {
            boolean isAuthenticated = dao.authenticateCustomer(username, password);

            if (isAuthenticated) {
                System.out.println("Correct credentials!");
            } else {
                System.out.println("Invalid credentials!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error during authentication: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

}
