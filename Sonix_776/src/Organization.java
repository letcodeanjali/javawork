import java.util.HashSet;
import java.util.Set;

public class Organization {
	 Set<String> s1 = new HashSet<>();
     Set<String> s2 = new HashSet<>();

   
    public void addEmployee(String employee) {
        synchronized (s1) {
            s1.add(employee);
        }
    }

    public void addDepartment(String department) {
        synchronized (s2) {
            s2.add(department);
        }
    }

    public Set<String> getEmployees() {
        return s1;
    }

    public Set<String> getDepartments() {
        return s2;
    }



    public static void main(String[] args) {
        Organization organization = new Organization();

        
        organization.addEmployee("anjali");
        organization.addEmployee("tom");
        organization.addEmployee("naruto");
        

        
        organization.addDepartment("IT");
        organization.addDepartment("Sales");
        organization.addDepartment("HR");

        
        Thread employeeThread = new Thread(() -> {
            for (String employee : organization.getEmployees()) {
                System.out.println("Employee: " + employee);
            }
        });

        Thread departmentThread = new Thread(() -> {
            for (String department : organization.getDepartments()) {
                System.out.println("Department: " + department);
            }
        });

        // Start both threads
        employeeThread.start();
        departmentThread.start();

        try {
            
            employeeThread.join();
            departmentThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

