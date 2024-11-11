package pratice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class cust {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();

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
		Collections.sort(customers, new Comparator<Customer>() {
			@Override
			public int compare(Customer c1, Customer c2) {
				return c1.getCity().compareTo(c2.getCity());
			}
		});
		System.out.println("Sorted by city wise:");
		for (Customer customer : customers) {
			System.out.println("ID: " + customer.getCustId() + ", Name: " + customer.getCustName() + ", City: "
					+ customer.getCity() + ", Gender: " + customer.getGender() + ", Premium: " + customer.isPremium());
		}

		// Sorting by custName wise
		Collections.sort(customers, new Comparator<Customer>() {
			@Override
			public int compare(Customer c1, Customer c2) {
				return c1.getCustName().compareTo(c2.getCustName());
			}
		});
		System.out.println("\nSorted by custName wise:");
		for (Customer customer : customers) {
			System.out.println("ID: " + customer.getCustId() + ", Name: " + customer.getCustName() + ", City: "
					+ customer.getCity() + ", Gender: " + customer.getGender() + ", Premium: " + customer.isPremium());
		}
	}
}
