package com.java.hib;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Victims")
public class Victim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "victimid")
	private int victimid;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "dateofbirth")
	private Date dateofbirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "phonenumber")
	private String phonenumber;

	@Column(name = "address")
	private String address;

	// Constructors, getters, and setters

	public Victim() {
	}

	public Victim(String firstname, String lastname, Date dateofbirth, String gender, String phonenumber,
			String address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.address = address;
	}

	// Getters and setters

	public int getVictimid() {
		return victimid;
	}

	public void setVictimid(int victimid) {
		this.victimid = victimid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Victim{" + "victimid=" + victimid + ", firstname='" + firstname + '\'' + ", lastname='" + lastname
				+ '\'' + ", dateofbirth=" + dateofbirth + ", gender='" + gender + '\'' + ", phonenumber='" + phonenumber
				+ '\'' + ", address='" + address + '\'' + '}';
	}
}
