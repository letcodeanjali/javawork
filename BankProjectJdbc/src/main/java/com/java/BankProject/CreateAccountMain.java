package com.java.BankProject;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateAccountMain {
	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name  ");
		bank.setFirstName(sc.next());
		System.out.println("Enter Last Name  ");
		bank.setLastName(sc.next());
		System.out.println("Enter City  ");
		bank.setCity(sc.next());
		System.out.println("Enter State   ");
		bank.setState(sc.next());
		System.out.println("Enter Amount   ");
		bank.setAmount(sc.nextDouble());
		System.out.println("Enter CheqFacil  ");
		bank.setCheqFacil(sc.next());
		System.out.println("Enter Account Type   ");
		bank.setAccountType(sc.next());
		
		BankDao dao = new BankDaoImpl();
		try {
			System.out.println(dao.createAccount(bank));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
