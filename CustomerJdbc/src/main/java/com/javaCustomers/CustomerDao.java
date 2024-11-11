package com.javaCustomers;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
	abstract List<Customer> showCustomerDao() throws ClassNotFoundException, SQLException;
	Customer searchCustomerDao(int cusId) throws ClassNotFoundException, SQLException;
	void addCustomer(Customer customer) throws SQLException, ClassNotFoundException;
	 boolean authenticateCustomer(String username, String password) throws SQLException, ClassNotFoundException;
	

}
