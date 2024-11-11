package java.com.hib;

import java.util.List;

public class EmployDao {
	List<Employ> showEmployDao();

	Employ searchEmployDao(int empno);

	String addUser(Users users);

	int authenticate(Users users);

	long validate(Users users);

	List<String> showDepartments();
}
