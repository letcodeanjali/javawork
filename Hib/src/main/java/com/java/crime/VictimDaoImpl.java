package com.java.crime;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class VictimDaoImpl implements VictimDao {
	SessionFactory sessionFactory;
	Session session;

	public List<Victims> showVictimDao() throws ClassNotFoundException, SQLException {

		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Victims");
		List<Victims> victimList = query.list();
		return victimList;
	}

	public Victims searchVictimDao(int victimid) throws ClassNotFoundException, SQLException {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Victims where victimid = " + victimid);
		Victims victims = (Victims) query.uniqueResult();
		return victims;
	}

	public String updateVictimDao(Victims victimUpdated) throws ClassNotFoundException, SQLException {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();

		session.saveOrUpdate(victimUpdated);
		trans.commit();
		return "Victim Record Updated...";
	}

	@Override
	public String addVictimDao(Victims victimNew) throws ClassNotFoundException, SQLException {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();

		java.sql.Date dateofbirth = new java.sql.Date(victimNew.getdateofbirth().getTime());
		victimNew.setdateofbirth(dateofbirth);

		session.saveOrUpdate(victimNew);
		trans.commit();
		return "Victim Record Inserted...";
	}

	public String deleteVictimDao(int victimid) throws ClassNotFoundException, SQLException {
		Victims victimFound = searchVictimDao(victimid);
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(victimFound);
		trans.commit();
		return "Victim Record Deleted...";
	}

}
