package com.javaCustomers;

import java.sql.SQLException;
import java.util.Scanner;

public class AddCustomerMain {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter Customer Name:");
	        String name = sc.nextLine();

	        System.out.println("Enter Customer Phone Number:");
	        String phoneNumber = sc.nextLine();

	        System.out.println("Enter Customer Username:");
	        String username = sc.nextLine();

	        System.out.println("Enter Customer Password:");
	        String password = sc.nextLine();

	        System.out.println("Enter Customer Email:");
	        String email = sc.nextLine();

	        Customer customer = new Customer(0, name, phoneNumber, username, password, email);

	        CustomerDao dao = new CustomerDaoImpl();
	        try {
	            dao.addCustomer(customer);
	        } catch (ClassNotFoundException | SQLException e) {
	            System.err.println("Error adding customer: " + e.getMessage());
	        } finally {
	            sc.close();
	        }
	    }

}
