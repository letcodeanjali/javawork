package com.javaCustomers;

import java.sql.SQLException;
import java.util.List;

public class CustomerShow {
	public static void main(String[] args) {
		CustomerDao dao = new CustomerDaoImpl();
		try {
			List<Customer> customerList = dao.showCustomerDao();
			for (Customer customer : customerList) {
				System.out.println(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
