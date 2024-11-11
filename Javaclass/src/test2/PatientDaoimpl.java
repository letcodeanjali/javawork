package test2;

import java.util.ArrayList;
import java.util.List;

public class PatientDaoimpl implements PatientDao {

    List<Patient> patientList;

    public PatientDaoimpl() {
        patientList = new ArrayList<>();
    }

    @Override
    public List<Patient> showPatients() {
        return patientList;
    }

    @Override
    public String addPatient(Patient patient) {
        patientList.add(patient);
        return "Patient record inserted";
    }

    @Override
    public Patient searchPatient(int patientId) {
        for (Patient patient : patientList) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    @Override
    public String deletePatient(int patientId) {
        Patient patientFound = searchPatient(patientId);
        if (patientFound != null) {
            patientList.remove(patientFound);
            return "Patient Record Deleted...";
        }
        return "Patient Record Not Found...";
    }

    @Override
    public String updatePatient(Patient patient) {
        for (Patient p : patientList) {
            if (p.getPatientId() == patient.getPatientId()) {
                p.setPatientName(patient.getPatientName());
                p.setGender(patient.getGender());
                p.setCity(patient.getCity());
                p.setAge(patient.getAge());
                // Update other attributes as needed
                return "Patient details updated successfully!";
            }
        }
        return "Patient not found!";
    }
}
