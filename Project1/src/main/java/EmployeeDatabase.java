import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
public class EmployeeDatabase {

	
	

	 private static final String DB_PROPERTIES_FILE = "db.properties";
	    
	 private static final String EMPLOYEES_PROPERTIES_FILE = "employees.properties";

	    private static Properties databaseProperties = new Properties();
	    private static Properties employeesProperties = new Properties();
	  

	    public static void main(String[] args) throws Exception {
	        // Reading database configuration from properties file
	        FileReader fr = new FileReader(DB_PROPERTIES_FILE);
	        Properties p = new Properties();
	        p.load(fr);

	        // Loading database driver class
	        String driverType = p.getProperty("driverType");
	        Class.forName(driverType);

	        // Establishing database connection
	       

	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_del", "root", "system");
	        // Example CRUD operations
	        insertEmployee("101", "John Doe", 50000);
	        insertEmployee("102", "Jane Smith", 60000);
	        displayEmployees();
	        updateEmployee("101", "John Doe", 50000, 55000);
	        displayEmployees();
	        deleteEmployee("102");
	        displayEmployees();

	        // Save the updated properties to the file
	        saveEmployeesProperties();
	    }

	    private static void loadDatabaseProperties() {
	        try (InputStream input = new FileInputStream(DB_PROPERTIES_FILE)) {
	            databaseProperties.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void loadEmployeesProperties() {
	        try (InputStream input = new FileInputStream(EMPLOYEES_PROPERTIES_FILE)) {
	            employeesProperties.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void saveEmployeesProperties() {
	        try (OutputStream output = new FileOutputStream(EMPLOYEES_PROPERTIES_FILE)) {
	            employeesProperties.store(output, null);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void displayEmployees() {
	        System.out.println("\nEmployee Details:");

	        Set<String> employeeIds = employeesProperties.stringPropertyNames();
	        for (String employeeId : employeeIds) {
	            String[] employeeInfo = employeesProperties.getProperty(employeeId).split(",");
	            String employeeName = employeeInfo[0].trim();
	            int salary = Integer.parseInt(employeeInfo[1].trim());

	            System.out.println("Employee ID: " + employeeId + ", Name: " + employeeName + ", Salary: " + salary);
	        }
	    }

	    private static void insertEmployee(String id, String name, int salary) {
	        String employeeInfo = name + ", " + salary;
	        employeesProperties.setProperty(id, employeeInfo);
	        System.out.println("Employee inserted successfully!\n");
	    }

	    private static void updateEmployee(String id, String name, int oldSalary, int newSalary) {
	        String oldEmployeeInfo = name + ", " + oldSalary;

	        if (employeesProperties.containsKey(id) && employeesProperties.getProperty(id).equals(oldEmployeeInfo)) {
	            String newEmployeeInfo = name + ", " + newSalary;
	            employeesProperties.setProperty(id, newEmployeeInfo);
	            System.out.println("Employee updated successfully!\n");
	        } else {
	            System.out.println("Employee with ID '" + id + "' not found or information does not match. Update failed.\n");
	        }
	    }

	    private static void deleteEmployee(String id) {
	        if (employeesProperties.containsKey(id)) {
	            employeesProperties.remove(id);
	            System.out.println("Employee deleted successfully!\n");
	        } else {
	            System.out.println("Employee with ID '" + id + "' not found. Delete failed.\n");
	        }
	    }
	}


