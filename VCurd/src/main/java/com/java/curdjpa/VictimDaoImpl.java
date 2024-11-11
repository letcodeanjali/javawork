package com.java.curdjpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class VictimDaoImpl implements VictimDao {
	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Victim> showVictimDao() throws ClassNotFoundException, SQLException {
		List<Victim> victimList = new ArrayList<Victim>();
		String cmd = "select * from Victims";
		connection = Connection.getConnection();
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Victim victim = null;
		while (rs.next()) {
			victim = new Victim();
			victim.setVictimID(rs.getInt("victimID"));
			victim.setFirstName(rs.getString("firstName"));
			victim.setLastName(rs.getString("lastName"));
			victim.setDateOfBirth(rs.getDate("dateofbirth"));
			victim.setGender(rs.getString("gender"));
			victim.setPhoneNumber(rs.getString("phoneNumber"));
			victim.setAddress(rs.getString("address"));
			victimList.add(victim);
		}
		return victimList;
	}

	@Override
	public Victim searchVictimDao(int victimID) throws ClassNotFoundException, SQLException {
		List<Victim> victimList = new ArrayList<Victim>();
		String cmd = "select * from Victims where victimId = ?";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, victimID);
		ResultSet rs = pst.executeQuery();
		Victim victim = null;
		if (rs.next()) {
			victim = new Victim();
			victim.setVictimID(rs.getInt("victimId"));
			victim.setFirstName(rs.getString("firstName"));
			victim.setLastName(rs.getString("lastName"));
			victim.setDateOfBirth(rs.getDate("dateofbirth"));
			victim.setGender(rs.getString("gender"));
			victim.setPhoneNumber(rs.getString("phoneNumber"));
			victim.setAddress(rs.getString("address"));
			victimList.add(victim);
		}
		return victim;
	}

	@Override
	public String addVictimDao(Victim victimNew) throws ClassNotFoundException, SQLException {
		String cmd = "Insert into victims (victimId,firstname,lastname,dateofbirth,gender,phoneNumber,address)  values(?,?,?,?,?,?,?)";
		connection = Connection.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, victimNew.getVictimID());
		pst.setString(2, victimNew.getFirstName());
		pst.setString(3, victimNew.getLastName());
		pst.setDate(4, victimNew.getDateOfBirth());
		pst.setString(5, victimNew.getGender());
		pst.setString(6, victimNew.getPhoneNumber());
		pst.setString(7, victimNew.getAddress());

		pst.executeUpdate();
		return "***Victim Record Inserted****";
	}

	@Override
	public String deleteVictimDao(int victimID) throws ClassNotFoundException, SQLException {
		Connection connection = Connection.getConnection();
		try {
			// Start a transaction
			connection.setAutoCommit(false);

			// Delete related records from incidents (if needed)
			String deleteIncidentsCmd = "DELETE FROM incidents WHERE VictimID = ?";
			PreparedStatement pstIncidents = connection.prepareStatement(deleteIncidentsCmd);
			pstIncidents.setInt(1, victimID);
			pstIncidents.executeUpdate();

			// Now delete the victim
			String deleteVictimCmd = "DELETE FROM victims WHERE victimID = ?";
			PreparedStatement pstVictim = connection.prepareStatement(deleteVictimCmd);
			pstVictim.setInt(1, victimID);
			int rowsAffected = pstVictim.executeUpdate();

			// Commit transaction
			connection.commit();

			if (rowsAffected > 0) {
				return "Victim record deleted successfully.";
			} else {
				return "No victim found with ID: " + victimID;
			}
		} catch (SQLException e) {
			connection.rollback(); // Rollback the transaction in case of error
			throw e;
		} finally {
			connection.close();
		}
	}

	@Override
	public String updateVictimDao(Victim victimNew) throws ClassNotFoundException, SQLException {
		String cmd = "UPDATE Victims SET firstname=?, lastname=?, dateofbirth=?, gender=?, PhoneNumber=?, address=? WHERE victimid=?";
		Connection connection = ConnectionHelper.getConnection();
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setString(1, victimNew.getFirstName());
		pst.setString(2, victimNew.getLastName());
		pst.setDate(3, victimNew.getDateOfBirth());
		pst.setString(4, victimNew.getGender());
		pst.setString(5, victimNew.getPhoneNumber());
		pst.setString(6, victimNew.getAddress());
		pst.setInt(7, victimNew.getVictimID());

		int rowsUpdated = pst.executeUpdate();
		if (rowsUpdated > 0) {
			return "Victim Record Updated Successfully";
		} else {
			return "Victim Record Update Failed";
		}
	}

}
