package com.java.Complaint;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Component
public class SessionHelper {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
