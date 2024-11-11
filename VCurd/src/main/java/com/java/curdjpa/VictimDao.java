package com.java.curdjpa;

import java.sql.SQLException;

import java.util.List;

public interface VictimDao {

	List<Victim> showVictimDao() throws ClassNotFoundException, SQLException;

	Victim searchVictimDao(int victimID) throws ClassNotFoundException, SQLException;

	String addVictimDao(Victim victimNew) throws ClassNotFoundException, SQLException;

	String deleteVictimDao(int victimID) throws ClassNotFoundException, SQLException;

	String updateVictimDao(Victim victimNew) throws ClassNotFoundException, SQLException;

}
