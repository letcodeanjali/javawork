package com.javaCustomers;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerSearchMain {
	public static void main(String[] args) {
		int cusId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Id  ");
		cusId = sc.nextInt();
		CustomerDao dao = new CustomerDaoImpl();
		try {
			Customer customer = dao.searchCustomerDao(cusId);
			if (customer!=null) {
				System.out.println(customer);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
