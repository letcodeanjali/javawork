package com.java.doctor;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class AptDaoImpl implements AptDao{
	SessionFactory sessionFactory;
	Session session;
	@Override
	public List<Appointment> showAppointmentDao() throws ClassNotFoundException, SQLException {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Appointment");
		List<Appointment> appointmentList = query.list();
		return appointmentList;
	}

	@Override
	public String addAppointmentDao(Appointment appointmentNew)
			throws ClassNotFoundException, SQLException, ParseException {
		sessionFactory = SessionHelper.getConnection();
	    session = sessionFactory.openSession();
	    Transaction trans = session.beginTransaction();	   	    
	    session.saveOrUpdate(appointmentNew);
	    trans.commit();
	    return "Appointment Record Inserted...";
	}

	@Override
	public String deleteAppointmentDao(int appointmentId) throws ClassNotFoundException, SQLException {
		Appointment appointmentFound = searchAppointmentDao(appointmentId);
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(appointmentFound);
		trans.commit();
		return "Appointment Record Deleted...";
	}

	@Override
	public Appointment searchAppointmentDao(int appointmentId) throws ClassNotFoundException, SQLException {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Appointment where appointmentId = "+appointmentId);
		Appointment appointment = (Appointment)query.uniqueResult();
		return appointment;
	}
	@Override
	public boolean isAppointmentAvailable(Appointment appointment) throws ClassNotFoundException, SQLException {
	    sessionFactory = SessionHelper.getConnection();
	    session = sessionFactory.openSession();
	    Query query = session.createQuery("from Appointment where appointmentDate = :appointmentDate and appointTime = :appointTime");
	    query.setParameter("appointmentDate", appointment.getAppointmentDate());
	    query.setParameter("appointTime", appointment.getAppointTime());
	    List<Appointment> appointmentList = query.list();
	    return appointmentList.isEmpty();
	}

}
