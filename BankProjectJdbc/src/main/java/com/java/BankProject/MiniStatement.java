package com.java.BankProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MiniStatement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account No: ");
        int accountNo = sc.nextInt();

        BankDao dao = new BankDaoImpl();

        try {
            String miniStatement = dao.miniStatement(accountNo);

            if (!miniStatement.isEmpty()) {
                System.out.println("Mini Statement for Account Number " + accountNo + ":");
                System.out.println(miniStatement);
            } else {
                System.out.println("* No transactions found for Account Number " + accountNo + " *");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error executing database operation: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close(); 
        }
    }
    public String miniStatement(int accountNo) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder miniStatementBuilder = new StringBuilder();

        try {
            connection = ConnectionHelper.getConnection();
            if (connection != null) {
            	String query = "SELECT TransAmount, TransType, TransDate FROM trans WHERE AccountNo = ? ORDER BY TransDate DESC";

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, accountNo);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    double transAmount = resultSet.getDouble("TransAmount");
                    String transType = resultSet.getString("TransType");
                    String transDate = resultSet.getString("TransDate");

                    String transactionInfo = String.format("Transaction: %s $%.2f on %s\n", transType, transAmount, transDate);
                    miniStatementBuilder.append(transactionInfo);
                }
            } else {
                // Handle connection failure
                throw new SQLException("Failed to establish database connection");
            }
        } finally {
            // Close resources in reverse order of creation
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return miniStatementBuilder.toString();
    }

}
