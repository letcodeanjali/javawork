package com.java.BankProject;
import java.sql.SQLException;

public interface BankDao {
	abstract String createAccount(Bank bank) throws ClassNotFoundException, SQLException;
	Bank searchAccount(int accountNo) throws ClassNotFoundException, SQLException;
	String depositAmount(int accountNo, double depositAmount) throws ClassNotFoundException, SQLException;
	String withdrawAmount(int accountNo, double withdrawAmount) throws ClassNotFoundException, SQLException;
	String updateAccount(int accountNo, String city, String state) throws ClassNotFoundException, SQLException;
	String closeAccount(int accountNo) throws ClassNotFoundException, SQLException;
	String miniStatement(int accountNo) throws ClassNotFoundException, SQLException;
	

}
