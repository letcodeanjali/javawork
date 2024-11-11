package com.java.hib;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class VictimDaoImpl implements VictimDao {

	private SessionFactory sessionFactory;

	public VictimDaoImpl() {
		this.sessionFactory = SessionHelper.getSessionFactory();
	}

	@Override
	public List<Victim> showVictimDao() throws SQLException {
		List<Victim> victimList;
		try (Session session = sessionFactory.openSession()) {
			Query<Victim> query = session.createQuery("from Victim", Victim.class);
			victimList = query.list();
		}
		return victimList;
	}

	@Override
	public Victim searchVictimDao(int victimid) throws SQLException {
		Victim victim;
		try (Session session = sessionFactory.openSession()) {
			victim = session.get(Victim.class, victimid);
		}
		return victim;
	}

	@Override
	public String updateVictimDao(Victim victimUpdated) throws SQLException {
		try (Session session = sessionFactory.openSession()) {
			Transaction trans = session.beginTransaction();
			session.saveOrUpdate(victimUpdated);
			trans.commit();
		}
		return "Victim Record Updated...";
	}

	@Override
	public String addVictimDao(Victim victimNew) throws SQLException {
		try (Session session = sessionFactory.openSession()) {
			Transaction trans = session.beginTransaction();
			session.saveOrUpdate(victimNew);
			trans.commit();
		}
		return "Victim Record Inserted...";
	}

	@Override
	public String deleteVictimDao(int victimId) throws SQLException {
		try (Session session = sessionFactory.openSession()) {
			Transaction trans = session.beginTransaction();
			Victim victimFound = session.get(Victim.class, victimId);
			if (victimFound != null) {
				session.delete(victimFound);
				trans.commit();
				return "Victim Record Deleted...";
			} else {
				return "Victim with ID " + victimId + " not found!";
			}
		}
	}
}
