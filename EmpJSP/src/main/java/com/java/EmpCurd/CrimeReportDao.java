package com.java.EmpCurd;

import java.sql.SQLException;

import java.util.List;

public interface CrimeReportDao {

	// Method to retrieve a list of all victims
	List<Victim> showVictims() throws ClassNotFoundException, SQLException;

	// Method to search for a victim by victimId
	Victim searchVictim(int victimId) throws ClassNotFoundException, SQLException;

	// Method to add a new victim
	String addVictim(Victim victim) throws ClassNotFoundException, SQLException;

	// Method to delete a victim by victimId
	String deleteVictim(int victimId) throws ClassNotFoundException, SQLException;

	// Method to update information of an existing victim
	String updateVictim(Victim victim) throws ClassNotFoundException, SQLException;
}
