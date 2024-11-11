package test2;
import java.util.List;

public interface PatientDao {
	

	    List<Patient> showPatients();
	    String addPatient(Patient patient);
	    Patient searchPatient(int patientId);
	    String deletePatient(int patientId);
	    String updatePatient(Patient patient);
	}



