package com.java.doctor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	 @Id 
		@Column(name="adminid")
	private int adminid;
	 @Column(name="hospitalid")
	private int hospitalid;
	 @Column(name="username")
	private String username;
	 @Column(name="passcode")
	private String passcode;
	 @Column(name="otp")
	private String otp;
	 @Column(name="otppurpose")
	private String otppurpose;
	 @Column(name="status")
	private String status;
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public int getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(int hospitalid) {
		this.hospitalid = hospitalid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getOtppurpose() {
		return otppurpose;
	}
	public void setOtppurpose(String otppurpose) {
		this.otppurpose = otppurpose;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Admin(int adminid, int hospitalid, String username, String passcode, String otp, String otppurpose,
			String status) {
		super();
		this.adminid = adminid;
		this.hospitalid = hospitalid;
		this.username = username;
		this.passcode = passcode;
		this.otp = otp;
		this.otppurpose = otppurpose;
		this.status = status;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
