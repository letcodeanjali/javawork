package com.java.customer;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CustomerDaoImpl implements CustomerDao {

	SessionFactory sessionFactory;
	Session session;
	
	public int getCustId() {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		List<Customer> customerList = cr.list();
		return customerList.get(customerList.size()-1).getCustId();
	}
	@Override
	public String addCustomer(Customer customer) {
		customer.setCustStatus(1);
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(customer);
		trans.commit();
		session.close();
		Otp otp = new Otp();
		int cid = getCustId();
		String otpCode = OtpGen.genrateOtp();
		otp.setCustId(cid);
		otp.setOtpCode(otpCode);
		otp.setOtpPurpose("Creating Account");
		otp.setOtpStatus("ACTIVE");
		session = sessionFactory.openSession();
		trans = session.beginTransaction();
		session.save(otp);
		trans.commit();
		String result = "Your Otp Code Generated as  " +otpCode;
		SendMail.mail(customer.getCustEmail(), "One Time Password", result);
		return "Account Created...Otp Send to your Mail Account...";
	}
	
	public int getCustId(String custUser) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("custUserName", custUser));
		Customer customer = (Customer)cr.uniqueResult();
		return customer.getCustId();
	}
	@Override
	public int validateOtp(String user, String otp) {
		int cid = getCustId(user);
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Otp.class);
		cr.add(Restrictions.eq("custId", cid));
		cr.add(Restrictions.eq("otpCode", otp));
		cr.add(Restrictions.eq("otpStatus", "ACTIVE"));
		Otp otpObj = (Otp)cr.uniqueResult();
		if (otpObj!=null) {
			return 1;
		}
		return 0;
	}
	
}
