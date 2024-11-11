package com.java.crime;

import java.sql.SQLException;

import java.util.List;

public interface VictimDao {

	List<Victims> showVictimDao() throws ClassNotFoundException, SQLException;

	Victims searchVictimDao(int victimid) throws ClassNotFoundException, SQLException;

	String updateVictimDao(Victims victimNew) throws ClassNotFoundException, SQLException;

	String addVictimDao(Victims victimNew) throws ClassNotFoundException, SQLException;

	String deleteVictimDao(int victimId) throws ClassNotFoundException, SQLException;
}
