package com.java.hib;

import java.sql.SQLException;

import java.util.List;

public interface VictimDao {
	List<Victim> showVictimDao() throws SQLException;

	Victim searchVictimDao(int victimid) throws SQLException;

	String updateVictimDao(Victim victimUpdated) throws SQLException;

	String addVictimDao(Victim victimNew) throws SQLException;

	String deleteVictimDao(int victimId) throws SQLException;
}
