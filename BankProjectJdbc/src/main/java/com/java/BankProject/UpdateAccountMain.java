package com.java.BankProject;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAccountMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int accountNo;
		String city, state;
		System.out.println("Enter Account No  ");
		accountNo = sc.nextInt();
		System.out.println("Enter City  ");
		city = sc.next();
		System.out.println("Enter State  ");
		state = sc.next();
		BankDao dao = new BankDaoImpl();
		try {
			System.out.println(dao.updateAccount(accountNo, city, state));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
