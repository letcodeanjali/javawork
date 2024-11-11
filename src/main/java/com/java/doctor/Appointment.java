package com.java.doctor;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Appointment")
public class Appointment {
	
	@Id 
	@Column(name="appointmentId")
	private int appointmentId;
	@Column(name="patientName")
   private String patientName ;
	@Column(name="patientEmail")
 private String patientEmail ;
	@Column(name="patientMobile")
 private String patientMobile;
	@Column(name="doctorName")
 private String doctorName;
	@Column(name="appointmentDate")
 private Date appointmentDate;
	@Column(name="appointTime")
private String appointTime;
	@Column(name="patientDisease")
private String patientDisease;
public int getAppointmentId() {
	return appointmentId;
}
public void setAppointmentId(int appointmentId) {
	this.appointmentId = appointmentId;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getPatientEmail() {
	return patientEmail;
}
public void setPatientEmail(String patientEmail) {
	this.patientEmail = patientEmail;
}
public String getPatientMobile() {
	return patientMobile;
}
public void setPatientMobile(String patientMobile) {
	this.patientMobile = patientMobile;
}
public String getDoctorName() {
	return doctorName;
}
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public Date getAppointmentDate() {
	return appointmentDate;
}
public void setAppointmentDate(Date appointmentDate) {
	this.appointmentDate = appointmentDate;
}
public String getAppointTime() {
	return appointTime;
}
public void setAppointTime(String appointTime) {
	this.appointTime = appointTime;
}
public String getPatientDisease() {
	return patientDisease;
}
public void setPatientDisease(String patientDisease) {
	this.patientDisease = patientDisease;
}
public Appointment(int appointmentId, String patientName, String patientEmail, String patientMobile, String doctorName,
		Date appointmentDate, String appointTime, String patientDisease) {
	super();
	this.appointmentId = appointmentId;
	this.patientName = patientName;
	this.patientEmail = patientEmail;
	this.patientMobile = patientMobile;
	this.doctorName = doctorName;
	this.appointmentDate = appointmentDate;
	this.appointTime = appointTime;
	this.patientDisease = patientDisease;
}
public Appointment() {
	super();
	// TODO Auto-generated constructor stub
}
 
}
