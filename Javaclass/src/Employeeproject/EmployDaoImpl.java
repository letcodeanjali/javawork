package Employeeproject;

import java.util.ArrayList;
import java.util.List;

public class EmployDaoImpl implements EmployDao {
    List<Employ> employList;

    public EmployDaoImpl() {
        employList = new ArrayList<>();
    }

    @Override
    public List<Employ> ShowEmployDao() {
        return employList;
    }

    @Override
    public String addEmployDao(Employ employ) {
        employList.add(employ);
        return "Employ record inserted";
    }

    @Override
	public Employ searchEmployDao(int empno) {
		Employ employFound = null;
		for (Employ employ : employList) {
			if (employ.getEmpno() == empno) {
				employFound = employ;
				break;
			}
		}
		return employFound;
	}

    @Override
    public String deleteEmployDao(int empno) {
        Employ employFound = searchEmployDao(empno);
        if (employFound != null) {
            employList.remove(employFound);
            return "Employ Record Deleted...";
        }
        return "Employ Record Not Found...";
    }

    @Override
    public String updateEmployDao(Employ employ) {
        for (Employ e : employList) {
            if (e.getEmpno() == employ.getEmpno()) {
                e.setName(employ.getName());
                e.setGender(employ.getGender());
                e.setDept(employ.getDept());
                e.setDesig(employ.getDesig());
                e.setBasic(employ.getBasic());
                return "Employee details updated successfully!";
            }
        }
        return "Employee not found!";
    }
}
