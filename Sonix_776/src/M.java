import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    private String name;
    
    public Employee(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

class Department {
    private String name;
    
    public Department(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

class Enterprise {
    private Map<Department, List<Employee>> departmentEmployees = new HashMap<>();

    public synchronized void addEmployeeToDepartment(Employee employee, Department department) {
        if (!departmentEmployees.containsKey(department)) {
            departmentEmployees.put(department, new ArrayList<>());
        }
        
        departmentEmployees.get(department).add(employee);
    }

    public synchronized void printEmployeeDepartmentAssignment() {
        for (Department department : departmentEmployees.keySet()) {
            System.out.println("Department: " + department.getName());
            List<Employee> employees = departmentEmployees.get(department);
            for (Employee employee : employees) {
                System.out.println("  Employee: " + employee.getName());
            }
        }
    }
}

public class M {
    public static void main(String[] args) {
    	Enterprise organization = new Enterprise();

        Department hr = new Department("HR");
        Department it = new Department("IT");

        Employee emp1 = new Employee("Alice");
        Employee emp2 = new Employee("Bob");
        Employee emp3 = new Employee("Charlie");

        organization.addEmployeeToDepartment(emp1, hr);
        organization.addEmployeeToDepartment(emp2, it);
        organization.addEmployeeToDepartment(emp3, hr);

        organization.printEmployeeDepartmentAssignment();
    }
}