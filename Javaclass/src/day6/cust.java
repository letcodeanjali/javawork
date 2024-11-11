package day6;

public class cust implements Comparable {
	int cId;
	String name;
	String city;
	double billAmount;
	/**
	 * @return the cId
	 */
	public int getcId() {
		return cId;
	}
	/**
	 * @param cId the cId to set
	 */
	public void setcId(int cId) {
		this.cId = cId;
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
	 * @return the billAmount
	 */
	public double getBillAmount() {
		return billAmount;
	}
	/**
	 * @param billAmount the billAmount to set
	 */
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "cust [cId=" + cId + ", name=" + name + ", city=" + city + ", billAmount=" + billAmount + "]";
	}
	public cust(int cId, String name, String city, double billAmount) {
		super();
		this.cId = cId;
		this.name = name;
		this.city = city;
		this.billAmount = billAmount;
	}
	public int compareTo(Object o) {
		cust custmer=(cust)o;
		return name.compareTo(custmer.getName());
	}

}
