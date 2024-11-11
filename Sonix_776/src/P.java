import java.util.ArrayList;
import java.util.Collections;
	import java.util.List;
public class P {
	
	    public static void main(String[] args) {
	        List<Patient> patients = new ArrayList<>();
	        
	       
	        patients.add(new Patient(1, "Anjali", "Paris", 32));
	        patients.add(new Patient(2, "tom", "Los Angeles", 28));
	        patients.add(new Patient(3, "hanok", "USA", 45));
	        patients.add(new Patient(4, "jon", "Newyork", 40));

	        
	        Collections.sort(patients);

	        System.out.println("Sorted by age:");
	        for (Patient patient : patients) {
	            System.out.println(patient.getName() + ", " + patient.getAge());
	        }

	        
	        Collections.sort(patients, Patient.NameLocationAgeComparator);

	        System.out.println("\nSorted by name, location, and age:");
	        for (Patient patient : patients) {
	            System.out.println(patient.getName() + ", " + patient.getLocation() + ", " + patient.getAge());
	        }
	    }
	}

