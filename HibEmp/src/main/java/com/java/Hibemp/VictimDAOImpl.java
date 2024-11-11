package com.java.Hibemp;

import java.util.List;

import javax.security.auth.login.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class VictimDAOImpl implements VictimDAO {
	private static SessionFactory factory;

	public VictimDAOImpl() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public void addVictim(Victim victim) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(victim);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public Victim getVictim(int victimId) {
		Session session = factory.openSession();
		Victim victim = null;
		try {
			victim = session.get(Victim.class, victimId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return victim;
	}

	@Override
	public List<Victim> getAllVictims() {
		Session session = factory.openSession();
		List<Victim> victims = null;
		try {
			victims = session.createQuery("FROM Victim").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return victims;
	}

	@Override
	public void updateVictim(Victim victim) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(victim);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteVictim(int victimId) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Victim victim = session.get(Victim.class, victimId);
			if (victim != null) {
				session.delete(victim);
				tx.commit();
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
