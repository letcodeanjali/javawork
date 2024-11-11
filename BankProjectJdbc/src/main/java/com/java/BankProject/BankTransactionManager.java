package com.java.BankProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class BankTransactionManager {
    private static final String STATUS_ACTIVE = "active";

    // Fetches mini statement for a given account number
    public void fetchMiniStatement(int accountNo) throws SQLException {
        try (Connection conn = ConnectionHelper.getConnection()) {
            String query = "SELECT TransAmount, TransType, TransDate " +
                           "FROM Trans " +
                           "WHERE AccountNo = ? " +
                           "ORDER BY TransDate DESC " +
                           "LIMIT 5";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, accountNo);

            ResultSet rs = stmt.executeQuery();

            System.out.println("Mini Statement for Account Number: " + accountNo);
            System.out.println("--------------------------------------------------");
            System.out.printf("%-15s %-10s %-20s%n", "Amount", "Type", "Transaction Date");
            System.out.println("--------------------------------------------------");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            while (rs.next()) {
                double amount = rs.getDouble("TransAmount");
                String type = rs.getString("TransType");
                String transDate = dateFormat.format(rs.getTimestamp("TransDate"));

                System.out.printf("%-15.2f %-10s %-20s%n", amount, type, transDate);
            }

        } catch (SQLException e) {
            System.out.println("Error occurred while fetching mini statement:");
            throw e; // Propagate the exception to the caller
        } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    // Handles deposit operation
    public void deposit(int accountNo, double amount) throws SQLException, ClassNotFoundException {
        if (!isAccountActive(accountNo)) {
            throw new IllegalArgumentException("Account is inactive. Deposit operation not allowed.");
        }

        try (Connection conn = ConnectionHelper.getConnection()) {
            conn.setAutoCommit(false); // Start transaction
            String depositQuery = "UPDATE Bank SET Amount = Amount + ? WHERE AccountNo = ?";
            PreparedStatement depositStmt = conn.prepareStatement(depositQuery);
            depositStmt.setDouble(1, amount);
            depositStmt.setInt(2, accountNo);
            depositStmt.executeUpdate();

            String transQuery = "INSERT INTO Trans (AccountNo, TransAmount, TransType) VALUES (?, ?, 'deposit')";
            PreparedStatement transStmt = conn.prepareStatement(transQuery);
            transStmt.setInt(1, accountNo);
            transStmt.setDouble(2, amount);
            transStmt.executeUpdate();

            conn.commit(); // Commit the transaction
            System.out.println("Deposit of " + amount + " successfully added to account " + accountNo);

        } catch (SQLException e) {
            System.out.println("Error occurred during deposit:");
            throw e; // Propagate the exception to the caller
        }
    }

    // Handles withdrawal operation
    public void withdraw(int accountNo, double amount) throws SQLException, ClassNotFoundException {
        if (!isAccountActive(accountNo)) {
            throw new IllegalArgumentException("Account is inactive. Withdrawal operation not allowed.");
        }

        try (Connection conn = ConnectionHelper.getConnection()) {
            conn.setAutoCommit(false); // Start transaction
            double currentBalance = getAccountBalance(accountNo, conn);

            if (currentBalance < amount) {
                throw new IllegalArgumentException("Insufficient funds. Withdrawal not allowed.");
            }

            String withdrawQuery = "UPDATE Bank SET Amount = Amount - ? WHERE AccountNo = ?";
            PreparedStatement withdrawStmt = conn.prepareStatement(withdrawQuery);
            withdrawStmt.setDouble(1, amount);
            withdrawStmt.setInt(2, accountNo);
            withdrawStmt.executeUpdate();

            String transQuery = "INSERT INTO Trans (AccountNo, TransAmount, TransType) VALUES (?, ?, 'withdrawal')";
            PreparedStatement transStmt = conn.prepareStatement(transQuery);
            transStmt.setInt(1, accountNo);
            transStmt.setDouble(2, amount);
            transStmt.executeUpdate();

            conn.commit(); // Commit the transaction
            System.out.println("Withdrawal of " + amount + " successfully deducted from account " + accountNo);

        } catch (SQLException e) {
            System.out.println("Error occurred during withdrawal:");
            throw e; // Propagate the exception to the caller
        } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    // Helper method to check if account status is active
    private boolean isAccountActive(int accountNo) throws SQLException, ClassNotFoundException {
        try (Connection conn = ConnectionHelper.getConnection()) {
            String query = "SELECT Status FROM Bank WHERE AccountNo = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, accountNo);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String status = rs.getString("Status");
                return STATUS_ACTIVE.equals(status);
            }
            return false; // Account not found
        }
    }

    // Helper method to retrieve current account balance
    private double getAccountBalance(int accountNo, Connection conn) throws SQLException {
        String query = "SELECT Amount FROM Bank WHERE AccountNo = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, accountNo);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("Amount");
        }
        throw new IllegalArgumentException("Account not found");
    }
}
