package com.javaCustomers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl  implements CustomerDao {
	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<Customer> showCustomerDao() throws ClassNotFoundException, SQLException {
		String cmd = "select * from customer";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Customer customer = null;
		List<Customer> customerList = new ArrayList<Customer>();
		while(rs.next()) {
			customer = new Customer();
			customer.setCusId(rs.getInt("CUS_Id"));
			customer.setCusName(rs.getString("CUS_NAME"));
			customer.setCusPhoneNo(rs.getString("CUS_PHN_NO"));
			customer.setCusUserName(rs.getString("CUS_USERNAME"));
			customer.setCusPassword(rs.getString("CUS_PASSWORD"));
			customer.setCusEmail(rs.getString("CUS_EMAIL"));
			customerList.add(customer);
		}
	    	return customerList;
	}

	@Override
	public Customer searchCustomerDao(int cusId) throws ClassNotFoundException, SQLException {
		String cmd = "select * from customer Where CUS_ID = ?";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, cusId);
		ResultSet rs = pst.executeQuery();
		Customer customer = null;
		if (rs.next()) {
			customer = new Customer();
			customer.setCusId(rs.getInt("CUS_Id"));
			customer.setCusName(rs.getString("CUS_NAME"));
			customer.setCusPhoneNo(rs.getString("CUS_PHN_NO"));
			customer.setCusUserName(rs.getString("CUS_USERNAME"));
			customer.setCusPassword(rs.getString("CUS_PASSWORD"));
			customer.setCusEmail(rs.getString("CUS_EMAIL"));
			
		}
	    	return customer;
		}

	@Override
	public void addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean authenticateCustomer(String username, String password) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
