package test2;

import java.util.Date;

public class Patient {
	
	

	
	    private int patientId;
	    private String patientName;
	    private String city;
	    private String admittedDate;
	    private String dischargeDate;
	    private double treatmentAmount;
	    private double medicalAmount;
	    private double roomRent;
	    private double totalBill;

	    public Patient(int patientId, String patientName, String city, String admittedDate, String dischargeDate,
	                   double treatmentAmount, double medicalAmount, double roomRent, double totalBill) {
	        this.patientId = patientId;
	        this.patientName = patientName;
	        this.city = city;
	        this.admittedDate = admittedDate;
	        this.dischargeDate = dischargeDate;
	        this.treatmentAmount = treatmentAmount;
	        this.medicalAmount = medicalAmount;
	        this.roomRent = roomRent;
	        this.totalBill = totalBill;
	    }

	    @Override
	    public String toString() {
	        return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", city=" + city +
	                ", admittedDate=" + admittedDate + ", dischargeDate=" + dischargeDate + ", treatmentAmount=" +
	                treatmentAmount + ", medicalAmount=" + medicalAmount + ", roomRent=" + roomRent +
	                ", totalBill=" + totalBill + "]";
	    }

	    // Getters and setters
	    public int getPatientId() {
	        return patientId;
	    }

	    public void setPatientId(int patientId) {
	        this.patientId = patientId;
	    }

	    public String getPatientName() {
	        return patientName;
	    }

	    public void setPatientName(String patientName) {
	        this.patientName = patientName;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public String getAdmittedDate() {
	        return admittedDate;
	    }

	    public void setAdmittedDate(String admittedDate) {
	        this.admittedDate = admittedDate;
	    }

	    public String getDischargeDate() {
	        return dischargeDate;
	    }

	    public void setDischargeDate(String dischargeDate) {
	        this.dischargeDate = dischargeDate;
	    }

	    public double getTreatmentAmount() {
	        return treatmentAmount;
	    }

	    public void setTreatmentAmount(double treatmentAmount) {
	        this.treatmentAmount = treatmentAmount;
	    }

	    public double getMedicalAmount() {
	        return medicalAmount;
	    }

	    public void setMedicalAmount(double medicalAmount) {
	        this.medicalAmount = medicalAmount;
	    }

	    public double getRoomRent() {
	        return roomRent;
	    }

	    public void setRoomRent(double roomRent) {
	        this.roomRent = roomRent;
	    }

	    public double getTotalBill() {
	        return totalBill;
	    }

	    public void setTotalBill(double totalBill) {
	        this.totalBill = totalBill;
	    }

		public Object getGender() {
			// TODO Auto-generated method stub
			return null;
		}

		public Object getAge() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setGender(Object gender) {
			// TODO Auto-generated method stub
			
		}

		public void setAge(Object age) {
			// TODO Auto-generated method stub
			
		}
	}