package com.java.doctor;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;





public class DoctorDaoImpl implements DoctorDao{
	SessionFactory sessionFactory;
	Session session;
	@Override
	public List<Doctor> showDoctorDao() throws ClassNotFoundException, SQLException {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Doctor");
		List<Doctor> doctorList = query.list();
		return doctorList;
	}

	@Override
	public String addDoctorDao(Doctor doctorNew) throws ClassNotFoundException, SQLException, ParseException {
		sessionFactory = SessionHelper.getConnection();
	    session = sessionFactory.openSession();
	    Transaction trans = session.beginTransaction();	   	    
	    session.saveOrUpdate(doctorNew);
	    trans.commit();
	    return "Doctor Record Inserted...";
	}

	@Override
	public List<Hospital> showHospitalDao() throws ClassNotFoundException, SQLException {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Hospital");
		List<Hospital> hospitalList = query.list();
		return hospitalList;
	}

	@Override
	public String addHospitalDao(Hospital hospitalNew) throws ClassNotFoundException, SQLException, ParseException {
	    sessionFactory = SessionHelper.getConnection();
	    session = sessionFactory.openSession();
	    Transaction trans = session.beginTransaction();

	    String otp = Otp.genrateOtp();
	    hospitalNew.setStatus("Active");

	    session.saveOrUpdate(hospitalNew);
	    trans.commit();

	    // send OTP to hospital's email
	    String subject = "OTP for Hospital Registration";
	    String body = "Your OTP for hospital registration is: " + otp;
	    String email = hospitalNew.getEmail();
	    String mailStatus = SendMail.mail(email, subject, body);

	    return "Hospital Record Inserted... " + mailStatus;
	}

	@Override
	public String deleteHospitalDao(int hospitalid) {
		Hospital hospitalFound = searchHospitalDao(hospitalid);
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(hospitalFound);
		trans.commit();
		return "Hospital Record Deleted...";

}

	@Override
	public Hospital searchHospitalDao(int hospitalid) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Hospital where hospitalid = "+hospitalid);
		Hospital hospital = (Hospital)query.uniqueResult();
		return hospital;
	}

	@Override
	public List<Admin> showAdminDao() throws ClassNotFoundException, SQLException {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Admin");
		List<Admin> adminList = query.list();
		return adminList;
	}

	@Override
	public String addAdminDao(Admin adminNew) throws ClassNotFoundException, SQLException, ParseException {
		sessionFactory = SessionHelper.getConnection();
	    session = sessionFactory.openSession();
	    Transaction trans = session.beginTransaction();	   	    
	    session.saveOrUpdate(adminNew);
	    trans.commit();
	    return "Admin Record Inserted...";
	}
}
