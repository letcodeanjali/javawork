package Test2;

import java.sql.*;
import java.util.*;

public class Test {

	public static void main(String[] args) throws SQLException {
		Employee ep=new Employee();
		EmpDAOImp ed=new EmpDAOImp();
		
		/*
		 * Read Operations
		 */
		List<Employee> ls=ed.getEmployees1();
		for(Employee allemp:ls) {
			System.out.println(allemp);
		}
		
		/*
		 * Delete Operations
		 */
		ed.delete(0);
		
	}

}
