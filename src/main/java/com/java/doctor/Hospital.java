package com.java.doctor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Hospital")
public class Hospital {
	
	 @Id
	  
		@Column(name="hospitalid")
	private int hospitalid;
	  
		@Column(name="hospitalname")
	private String hospitalname;
		@Column(name="city")
	private String city;
		@Column(name="hospitaltype")
	private String hospitaltype;
		@Column(name="email")
	private String email;
		@Column(name="phoneno")
	private String phoneno;
		@Column(name="status")
	private String status;
		
	public int getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(int hospitalid) {
		this.hospitalid = hospitalid;
	}
	public String getHospitalname() {
		return hospitalname;
	}
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHospitaltype() {
		return hospitaltype;
	}
	public void setHospitaltype(String hospitaltype) {
		this.hospitaltype = hospitaltype;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Hospital(int hospitalid, String hospitalname, String city, String hospitaltype, String email, String phoneno,
			String status) {
		super();
		this.hospitalid = hospitalid;
		this.hospitalname = hospitalname;
		this.city = city;
		this.hospitaltype = hospitaltype;
		this.email = email;
		this.phoneno = phoneno;
		this.status = status;
	}
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
