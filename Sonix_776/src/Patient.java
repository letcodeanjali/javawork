import java.util.Comparator;

public class Patient implements Comparable<Patient>{
	
	     int patientID;
	     String name;
	     String location;
	     int age;

	    public Patient(int patientID, String name, String location, int age) {
	        this.patientID = patientID;
	        this.name = name;
	        this.location = location;
	        this.age = age;
	    }

	    public int getPatientID() {
	        return patientID;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public int getAge() {
	        return age;
	    }

	    
	    @Override
	    public int compareTo(Patient other) {
	        return Integer.compare(this.age, other.age);
	    }

	    
	    public static Comparator<Patient> NameLocationAgeComparator = new Comparator<Patient>() {
	        @Override
	        public int compare(Patient p1, Patient p2) {
	            
	            int nameComparison = p1.getName().compareTo(p2.getName());
	            if (nameComparison != 0) {
	                return nameComparison;
	            }

	            
	            int locationComparison = p1.getLocation().compareTo(p2.getLocation());
	            if (locationComparison != 0) {
	                return locationComparison;
	            }

	            
	            return Integer.compare(p1.getAge(), p2.getAge());
	        }
	    };
	}


