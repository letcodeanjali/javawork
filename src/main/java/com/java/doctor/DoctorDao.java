package com.java.doctor;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;







public interface DoctorDao {
	
	List<Doctor> showDoctorDao() throws ClassNotFoundException, SQLException;
	String addDoctorDao(Doctor doctorNew) throws ClassNotFoundException, SQLException, ParseException;
	List<Hospital> showHospitalDao() throws ClassNotFoundException, SQLException;
	String addHospitalDao(Hospital hospitalNew) throws ClassNotFoundException, SQLException, ParseException;
	String deleteHospitalDao(int hospitalid);
	Hospital searchHospitalDao(int hospitalid);
	List<Admin> showAdminDao() throws ClassNotFoundException, SQLException;
	String addAdminDao(Admin adminNew) throws ClassNotFoundException, SQLException, ParseException;
}
