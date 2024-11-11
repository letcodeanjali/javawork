package com.java.EmpCurd;

public class Victim {
	private int victimId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String phoneNumber;
	private String address;

	// Default constructor
	public Victim() {
		// No-arg constructor
	}

	// Parameterized constructor
	public Victim(int victimId, String firstName, String lastName, String dateOfBirth, String gender,
			String phoneNumber, String address) {
		this.victimId = victimId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	// Getters and Setters (Accessors and Mutators)
	public int getVictimId() {
		return victimId;
	}

	public void setVictimId(int victimId) {
		this.victimId = victimId;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
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

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// toString method for debugging and logging
	@Override
	public String toString() {
		return "Victim [victimId=" + victimId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
}
