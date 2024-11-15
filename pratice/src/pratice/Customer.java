package pratice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Customer {
	private int custId;
	private String custName;
	private String city;
	private String gender;
	private boolean premium;

	public Customer(int custId, String custName, String city, String gender, boolean premium) {
		this.custId = custId;
		this.custName = custName;
		this.city = city;
		this.gender = gender;
		this.premium = premium;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", city=" + city + ", gender=" + gender
				+ ", premium=" + premium + "]";
	}
}

class Main {
	public static void main(String[] args) {
		// Create a list to store customers
		List<Customer> customers = new ArrayList<>();

		// Adding 10 customer records
		customers.add(new Customer(1, "sushma", "mumbai", "Female", true));
		customers.add(new Customer(2, "padmanjali", "Bengaluru", "Female", false));
		customers.add(new Customer(3, "Chandra", "kolkata", "Male", true));
		customers.add(new Customer(4, "vara", "jaipur", "Female", false));
		customers.add(new Customer(5, "rajesh", "chennai", "Male", true));
		customers.add(new Customer(6, "likith", "Agra", "Male", true));
		customers.add(new Customer(7, "tarak", "Hyderabad", "Male", false));
		customers.add(new Customer(8, "meghana", "visakhapatnam", "Female", true));
		customers.add(new Customer(9, "vigneshwar", "patna", "Male", true));
		customers.add(new Customer(10, "shabir", "pune", "Male", false));

		// Sorting by city wise
		Collections.sort(customers, Comparator.comparing(Customer::getCity));
		System.out.println("Sorted by city wise:");
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		// Sorting by custName wise
		Collections.sort(customers, Comparator.comparing(Customer::getCustName));
		System.out.println("\nSorted by custName wise:");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
}