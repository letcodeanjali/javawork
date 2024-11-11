package test2;

import java.util.Scanner;

public class PatientMain {

    static Scanner sc = new Scanner(System.in);
    static PatientBal patBal = new PatientBal();

    public static void searchPatientMain() {
        int patientId;
        System.out.println("Enter Patient ID: ");
        patientId = sc.nextInt();
        Patient patient = patBal.searchPatient(patientId);
        if (patient != null) {
            System.out.println(patient);
        } else {
            System.out.println("*** Record Not Found ***");
        }
    }

    public static void addPatientMain() {
        Patient patient = new Patient(0, null, null, null, null, 0, 0, 0, 0);
        System.out.println("Enter Patient ID: ");
        patient.setPatientId(sc.nextInt());
        System.out.println("Enter Patient Name: ");
        patient.setPatientName(sc.next());
        System.out.println("Enter City: ");
        patient.setCity(sc.next());
        System.out.println("Enter Admitted Date (YYYY-MM-DD): ");
        patient.setAdmittedDate(sc.next());
        System.out.println("Enter Discharge Date (YYYY-MM-DD): ");
        patient.setDischargeDate(sc.next());
        System.out.println("Enter Treatment Amount: ");
        patient.setTreatmentAmount(sc.nextDouble());
        System.out.println("Enter Medical Amount: ");
        patient.setMedicalAmount(sc.nextDouble());
        System.out.println("Enter Room Rent: ");
        patient.setRoomRent(sc.nextDouble());
        System.out.println("Enter Total Bill: ");
        patient.setTotalBill(sc.nextDouble());
        try {
            System.out.println(patBal.addPatient(patient));
        } catch (PatientException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void deletePatientMain() {
        System.out.println("Enter Patient ID to delete: ");
        int patientId = sc.nextInt();
        System.out.println(patBal.deletePatient(patientId));
    }

    public static void updatePatientMain() {
        Patient patient = new Patient(0, null, null, null, null, 0, 0, 0, 0);
        System.out.println("Enter Patient ID to update: ");
        int patientId = sc.nextInt();
        patient.setPatientId(patientId);
        System.out.println("Enter Patient Name: ");
        patient.setPatientName(sc.next());
        System.out.println("Enter City: ");
        patient.setCity(sc.next());
        System.out.println("Enter Admitted Date (YYYY-MM-DD): ");
        patient.setAdmittedDate(sc.next());
        System.out.println("Enter Discharge Date (YYYY-MM-DD): ");
        patient.setDischargeDate(sc.next());
        System.out.println("Enter Treatment Amount: ");
        patient.setTreatmentAmount(sc.nextDouble());
        System.out.println("Enter Medical Amount: ");
        patient.setMedicalAmount(sc.nextDouble());
        System.out.println("Enter Room Rent: ");
        patient.setRoomRent(sc.nextDouble());
        System.out.println("Enter Total Bill: ");
        patient.setTotalBill(sc.nextDouble());
        try {
            System.out.println(patBal.updatePatient(patient));
        } catch (PatientException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void showPatientsMain() {
        System.out.println("List of Patients:");
        for (Patient patient : patBal.showPatients()) {
            System.out.println(patient);
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("OPTIONS");
            System.out.println("-------");
            System.out.println("1. Add Patient");
            System.out.println("2. Show Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Update Patient");
            System.out.println("6. Exit");
            System.out.println("Enter Your Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addPatientMain();
                    break;
                case 2:
                    showPatientsMain();
                    break;
                case 3:
                    searchPatientMain();
                    break;
                case 4:
                    deletePatientMain();
                    break;
                case 5:
                    updatePatientMain();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);
    }
}
