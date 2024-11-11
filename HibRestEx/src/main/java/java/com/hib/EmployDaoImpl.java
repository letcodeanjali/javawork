package java.com.hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmployDaoImpl implements EmployDao {

	SessionFactory sessionFactory;
	Session session;

	@Override
	public List<Employ> showEmployDao() {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		List<Employ> employList = cr.list();
		return employList;
	}

	@Override
	public Employ searchEmployDao(int empno) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		cr.add(Restrictions.eq("empno", empno));
		Employ employ = (Employ) cr.uniqueResult();
		return employ;
	}

	@Override
	public String addUser(Users users) {
		String passCode = EncryptPassword.getCode(users.getPassCode());
		users.setPassCode(passCode);
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(users);
		trans.commit();
		// TODO Auto-generated method stub
		return "User Account Created Successfully...";
	}

	@Override
	public int authenticate(Users users) {
		String passCode = EncryptPassword.getCode(users.getPassCode());
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Users.class);
		cr.add(Restrictions.eq("userName", users.getUserName()));
		cr.add(Restrictions.eq("passCode", passCode));
		Users userFound = (Users) cr.uniqueResult();
		if (userFound != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public long validate(Users users) {
		String passCode = EncryptPassword.getCode(users.getPassCode());
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Users.class);
		cr.add(Restrictions.eq("userName", users.getUserName()));
		cr.add(Restrictions.eq("passCode", passCode));
		cr.setProjection(Projections.rowCount());
		long count = (Long) cr.uniqueResult();
		return count;
	}

	@Override
	public List<String> showDepartments() {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		Projection projection = Projections.distinct(Projections.property("dept"));
		cr.setProjection(projection);
		List<String> list = cr.list();
		return list;
	}

}