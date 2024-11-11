package com.java.EmpCurd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class VictimDAOimp {
	private Connection connection;

	public VictimDAOimp() {
		connection = DBConnection.getConnection();
	}

	public void addVictim(Victim victim) {
		try {
			String query = "INSERT INTO Victims (VictimID, FirstName, LastName, DateOfBirth, Gender, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, victim.getVictimId());
			pstmt.setString(2, victim.getFirstName());
			pstmt.setString(3, victim.getLastName());
			pstmt.setDate(4, Date.valueOf(victim.getDateOfBirth()));
			pstmt.setString(5, victim.getGender());
			pstmt.setString(6, victim.getPhoneNumber());
			pstmt.setString(7, victim.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Victim> getAllVictims() {
		List<Victim> victims = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Victims");
			while (rs.next()) {
				Victim victim = new Victim();
				victim.setVictimId(rs.getInt("VictimID"));
				victim.setFirstName(rs.getString("FirstName"));
				victim.setLastName(rs.getString("LastName"));
				victim.setDateOfBirth(rs.getDate("DateOfBirth").toString());
				victim.setGender(rs.getString("Gender"));
				victim.setPhoneNumber(rs.getString("PhoneNumber"));
				victim.setAddress(rs.getString("Address"));
				victims.add(victim);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return victims;
	}

	public Victim getVictimById(int victimID) {
		Victim victim = null;
		try {
			String query = "SELECT * FROM Victims WHERE VictimID = ?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, victimID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				victim = new Victim();
				victim.setVictimId(rs.getInt("VictimID"));
				victim.setFirstName(rs.getString("FirstName"));
				victim.setLastName(rs.getString("LastName"));
				victim.setDateOfBirth(rs.getDate("DateOfBirth").toString());
				victim.setGender(rs.getString("Gender"));
				victim.setPhoneNumber(rs.getString("PhoneNumber"));
				victim.setAddress(rs.getString("Address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return victim;
	}

	public void updateVictim(Victim victim) {
		try {
			String query = "UPDATE Victims SET FirstName = ?, LastName = ?, DateOfBirth = ?, Gender = ?, PhoneNumber = ?, Address = ? WHERE VictimID = ?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, victim.getFirstName());
			pstmt.setString(2, victim.getLastName());
			pstmt.setDate(3, Date.valueOf(victim.getDateOfBirth()));
			pstmt.setString(4, victim.getGender());
			pstmt.setString(5, victim.getPhoneNumber());
			pstmt.setString(6, victim.getAddress());
			pstmt.setInt(7, victim.getVictimId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteVictim(int victimID) {
		try {
			String query = "DELETE FROM Victims WHERE VictimID = ?";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, victimID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
