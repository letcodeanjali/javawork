
package com.java.emp;

import java.util.List;

public class EmployBal {

	static StringBuilder sb = new StringBuilder();
	
	static EmployDao dao = new EmployDaoImpl();
	
	public boolean validateEmploy(Employ employ) {
		
		boolean flag = true;
		
		if (employ.getEmpno() <= 0) {
			flag = false;
			sb.append("Employ No Cannot be Zero or Negative...\n");
		}
		
		if (employ.getName().length() < 5) {
			flag = false;
			sb.append("Employ Name Contains min. 5 characters...\n");
		}
		
		if (employ.getBasic() < 10000 || employ.getBasic() > 90000) {
			flag = false;
			sb.append("Basic Must be Between 10000 and 90000...");
		}
		return flag;
	}
	
	public String deleteEmployBal(int empno) {
		return dao.deleteEmployDao(empno);
	}
	
	public Employ searchEmployBal(int empno) {
		return dao.searchEmployDao(empno);
	}
	
	public List<Employ> showEmployBal() {
		return dao.showEmployDao();
	}
	
	public String addEmployBal(Employ employ) throws EmployException {
		if (validateEmploy(employ)==true) {
			return dao.addEmployDao(employ);
		}
		throw new EmployException(sb.toString());
	}
}
