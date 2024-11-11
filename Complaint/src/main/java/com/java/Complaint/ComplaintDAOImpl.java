package com.java.Complaint;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ComplaintDAOImpl implements ComplaintDAO {

	private SessionFactory sessionFactory;

	public ComplaintDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addComplaint(Complaint complaint) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(complaint);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public Complaint searchComplaint(int complaintID) {
		Session session = sessionFactory.openSession();
		try {
			return session.get(Complaint.class, complaintID);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Complaint> getAllComplaints() {
		Session session = sessionFactory.openSession();
		try {
			Query<Complaint> query = session.createQuery("FROM Complaint", Complaint.class);
			return query.getResultList();
		} finally {
			session.close();
		}
	}
}
