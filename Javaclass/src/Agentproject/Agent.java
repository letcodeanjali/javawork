package Agentproject;

public class Agent {
	                             
	
  private String agentName;
    private String city;
    private int payMode;
   private double premium;
public Agent() {
	
	// TODO Auto-generated constructor stub
}
public Agent(String agentName, String city, int payMode, double premium) {
	super();
	this.agentName = agentName;
	this.city = city;
	this.payMode = payMode;
	this.premium = premium;
}
@Override
public String toString() {
	return "Agent [agentName=" + agentName + ", city=" + city + ", payMode=" + payMode + ", premium=" + premium + "]";
}
/**
 * @return the agentName
 */
public String getAgentName() {
	return agentName;
}
/**
 * @param agentName the agentName to set
 */
public void setAgentName(String agentName) {
	this.agentName = agentName;
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
 * @return the payMode
 */
public int getPayMode() {
	return payMode;
}
/**
 * @param payMode the payMode to set
 */
public void setPayMode(int payMode) {
	this.payMode = payMode;
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
