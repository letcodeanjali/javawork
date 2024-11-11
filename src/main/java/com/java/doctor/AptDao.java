package com.java.doctor;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;



public interface AptDao {

	List<Appointment> showAppointmentDao() throws ClassNotFoundException, SQLException;
	String addAppointmentDao(Appointment appointmentNew) throws ClassNotFoundException, SQLException, ParseException;
	Appointment searchAppointmentDao(int appointmentId) throws ClassNotFoundException, SQLException;
	String deleteAppointmentDao(int appointmentId) throws ClassNotFoundException, SQLException;
	boolean isAppointmentAvailable(Appointment appointment) throws ClassNotFoundException, SQLException;
}
