package com.java.Agent;

public class Agent {
	private int agentID;
    private String name;
    private String city;
    private String gender;
    private int maritalStatus;
    private double premium;
	public Agent(int agentID, String name, String city, String gender, int maritalStatus, double premium) {
		super();
		this.agentID = agentID;
		this.name = name;
		this.city = city;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.premium = premium;
	}
	public Agent() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Agent [agentID=" + agentID + ", name=" + name + ", city=" + city + ", gender=" + gender
				+ ", maritalStatus=" + maritalStatus + ", premium=" + premium + "]";
	}
	/**
	 * @return the agentID
	 */
	public int getAgentID() {
		return agentID;
	}
	/**
	 * @param agentID the agentID to set
	 */
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the maritalStatus
	 */
	public int getMaritalStatus() {
		return maritalStatus;
	}
	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	/**
	 * @return the premium
	 */
	public double getPremium() {
		return premium;
	}
	/**
	 * @param premium the premium to set
	 */
	public void setPremium(double premium) {
		this.premium = premium;
	}

}
