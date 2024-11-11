package com.java.doctor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Doctor")
public class Doctor {
	 @Id
	  
	@Column(name="doctorid")
	private String doctorid;
	
	@Column(name="doctorname")
	private String doctorname;
	
	@Column(name="specialization")
	private String specialization;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="availableslot")
	private String availableslot;

	public String getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getAvailableslot() {
		return availableslot;
	}

	public void setAvailableslot(String availableslot) {
		this.availableslot = availableslot;
	}

	public Doctor(String doctorid, String doctorname, String specialization, String qualification,
			String availableslot) {
		super();
		this.doctorid = doctorid;
		this.doctorname = doctorname;
		this.specialization = specialization;
		this.qualification = qualification;
		this.availableslot = availableslot;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
