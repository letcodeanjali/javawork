package test2;
import java.util.List;

public class PatientBal {
	

	

	
	    static StringBuilder sb = new StringBuilder();
	    static PatientDaoimpl dao = new PatientDaoimpl();

	    public boolean validatePatient(Patient patient) {
	        boolean flag = true;

	        if (patient.getPatientId() <= 0) {
	            flag = false;
	            sb.append("Patient ID Cannot be Zero or Negative...\n");
	        }

	        if (patient.getPatientName().length() < 5) {
	            flag = false;
	            sb.append("Patient Name Must Contain at Least 5 Characters...\n");
	        }


	        return flag;
	    }

	    public String deletePatient(int patientId) {
	        return dao.deletePatient(patientId);
	    }

	    public Patient searchPatient(int patientId) {
	        return dao.searchPatient(patientId);
	    }

	    public List<Patient> showPatients() {
	        return dao.showPatients();
	    }

	    public String addPatient(Patient patient) throws PatientException {
	        if (validatePatient(patient)) {
	            return dao.addPatient(patient);
	        }
	        throw new PatientException(sb.toString());
	    }

	    public String updatePatient(Patient patient) throws PatientException {
	        if (validatePatient(patient)) {
	            return dao.updatePatient(patient);
	        }
	        throw new PatientException(sb.toString());
	    }
	}



