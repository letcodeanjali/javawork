
package com.java.emp;

import java.util.List;

public interface EmployDao {

	List<Employ> showEmployDao();
	String addEmployDao(Employ employ);
	Employ searchEmployDao(int empno);
	String deleteEmployDao(int empno);
}
