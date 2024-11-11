package Employeeproject;

import java.util.List;

public interface EmployDao {
    List<Employ> ShowEmployDao();
    String addEmployDao(Employ employ);
    Employ searchEmployDao(int empno);
    String deleteEmployDao(int empno);
    String updateEmployDao(Employ employ);
}
