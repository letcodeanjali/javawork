
package com.java.Curd;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployDaoImpl implements EmployDao {

	SessionFactory sessionFactory;
	Session session;

	@Override
	public List<Employ> showEmployDao() {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Employ");
		List<Employ> employList = query.list();
		return employList;
	}

	@Override
	public Employ searchEmployDao(int empno) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Employ where empno = " + empno);
		Employ employ = (Employ) query.uniqueResult();
		return employ;
	}

	@Override
	public String updateEmployDao(Employ employUpdated) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(employUpdated);
		trans.commit();
		return "Employ Record Updated...";
	}

	@Override
	public String deleteEmployDao(int empno) {
		Employ employFound = searchEmployDao(empno);
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(employFound);
		trans.commit();
		return "Employ Record Deleted...";
	}

	@Override
	public String addEmployDao(Employ employNew) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(employNew);
		trans.commit();
		return "Employ Record Inserted...";
	}

}
