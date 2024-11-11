package com.java.crime;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Victims")
public class Victims {
	@Id
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

	public Date getdateofbirth() {
		return dateofbirth;
	}

	public void setdateofbirth(Date dateofbirth) {
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

	public Victims(int victimid, String firstname, String lastname, Date dateofbirth, String gender, String phonenumber,
			String address) {
		super();
		this.victimid = victimid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.address = address;
	}

	public Victims() {
		super();
		// TODO Auto-generated constructor stub
	}

}
