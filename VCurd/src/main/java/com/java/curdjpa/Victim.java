package com.java.curdjpa;

import java.sql.Date;

public class Victim {

	private int victimID;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String phoneNumber;
	private String address;

	public int getVictimID() {
		return victimID;
	}

	public void setVictimID(int victimID) {
		this.victimID = victimID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String PhoneNumber) {
		this.phoneNumber = PhoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Victim(int victimID, String firstName, String lastName, Date dateOfBirth, String gender, String phoneNumber,
			String address) {

		this.victimID = victimID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Victim() {

	}

	@Override
	public String toString() {
		return "Victim [victimID=" + victimID + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}

}
