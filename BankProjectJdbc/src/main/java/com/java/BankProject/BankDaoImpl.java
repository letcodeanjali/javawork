package com.java.BankProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDaoImpl implements BankDao {
	Connection connection;
	PreparedStatement pst;
	
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(accountno) is null then 1 "
				+ " else max(accountno)+1 end accno from bank";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int accno = rs.getInt("accno");
		return accno;
	}
	
	public String createAccount(Bank bank) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		int accno = generateAccountNo();
		bank.setAccountNo(accno);
		String cmd = "Insert into Bank(AccountNo, FirstName, LastName, City, State, Amount,"
				+ "CheqFacil, AccountType) values(?, ?, ?, ?, ?, ?, ?, ?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, bank.getAccountNo());
		pst.setString(2, bank.getFirstName());
		pst.setString(3, bank.getLastName());
		pst.setString(4, bank.getCity());
		pst.setString(5, bank.getState());
		pst.setDouble(6, bank.getAmount());
		pst.setString(7, bank.getCheqFacil());
		pst.setString(8, bank.getAccountType());
		pst.executeUpdate();
		return "Account Created Successfully...";
	}

	@Override
	public Bank searchAccount(int accountNo) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Bank where accountNo = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		ResultSet rs = pst.executeQuery();
		Bank bank = null;
		if (rs.next()) {
			bank = new Bank();
			bank.setAccountNo(rs.getInt("accountNo"));
			bank.setFirstName(rs.getString("firstName"));
			bank.setLastName(rs.getString("lastName"));
			bank.setCity(rs.getString("city"));
			bank.setState(rs.getString("state"));
			bank.setAmount(rs.getDouble("amount"));
			bank.setCheqFacil(rs.getString("cheqFacil"));
			bank.setAccountType(rs.getString("accountType"));
		}
		return bank;
	}

	@Override
	public String depositAmount(int accountNo, double depositAmount) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccount(accountNo);
		if (bank !=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "update Bank set Amount = Amount + ? Where AccountNo = ?";
			pst = connection.prepareStatement(cmd);
			pst.setDouble(1, depositAmount);
			pst.setInt(2, accountNo);
			pst.executeUpdate();
			cmd = "Insert into Trans(AccountNo, TransAmount, TransType) "
					+ " values(?, ?, ?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, accountNo);
			pst.setDouble(2, depositAmount);
			pst.setString(3, "C");
			pst.executeUpdate();
			return "*** Amount Credited ***";
		}
		return "Account No Not Found...";
	}

	
	public String withdrawAmount(int accountNo, double withdrawAmount) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccount(accountNo);
		if (bank!=null) {
			double balance = bank.getAmount();
			if (balance - withdrawAmount >= 1000) {
				connection = ConnectionHelper.getConnection();
				String cmd = "update Bank set Amount = Amount - ? Where AccountNo = ?";
				pst = connection.prepareStatement(cmd);
				pst.setDouble(1, withdrawAmount);
				pst.setInt(2, accountNo);
				pst.executeUpdate();
				cmd = "Insert into Trans(AccountNo, TransAmount, TransType) "
						+ " values(?, ?, ?)";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, accountNo);
				pst.setDouble(2, withdrawAmount);
				pst.setString(3, "D");
				pst.executeUpdate();
				return "*** Amount Debited ***";				
			} else {
				return "Insufficient Funds...";
			} 
		}
		return "Account No Not Found...";
	}

	@Override
	public String updateAccount(int accountNo, String city, String state) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccount(accountNo);
		if (bank != null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "Update Bank set City = ?, State = ? Where AccountNo = ?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, city);
			pst.setString(2, state);
			pst.setInt(3, accountNo);
			pst.executeUpdate();
			return "Account Updated...";
		} else {
			return "Account No Not Found...";
		}
	}

	@Override
	public String closeAccount(int accountNo) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccount(accountNo);
		if (bank != null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "Update Bank set Status = 'inactive' Where AccountNo = ?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, accountNo);
			pst.executeUpdate();
			return "Account Updated...";
		} else {
			return "Account No Not Found...";
		}
	}

	 @Override
	    public String miniStatement(int accountNo) throws ClassNotFoundException, SQLException {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        StringBuilder miniStatementBuilder = new StringBuilder();

	        try {
	            connection = ConnectionHelper.getConnection(); // Get database connection
	            String query = "SELECT TransAmount, TransType, TransDate FROM Trans WHERE AccountNo = ? ORDER BY TransDate DESC";
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
