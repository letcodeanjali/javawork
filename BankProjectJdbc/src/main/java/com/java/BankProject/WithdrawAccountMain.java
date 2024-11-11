package com.java.BankProject;
import java.sql.SQLException;
import java.util.Scanner;

public class WithdrawAccountMain {
	public static void main(String[] args) {
		int accountNo;
		double withdrawAmount;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account No   ");
		accountNo = sc.nextInt();
		System.out.println("Enter Withdraw Amount  ");
		withdrawAmount = sc.nextDouble();
		BankDao dao = new BankDaoImpl();
		try {
			System.out.println(dao.withdrawAmount(accountNo, withdrawAmount));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
