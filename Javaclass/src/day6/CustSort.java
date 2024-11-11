package day6;

import java.util.SortedSet;
import java.util.TreeSet;

public class CustSort {
	public static void main(String[] args) {
		 SortedSet<cust> customers = new TreeSet<>();
	        customers.add(new cust(1, "anjali", "Hyderabad", 12345));
	        customers.add(new cust(2, "manju", "Bangalore", 12345));
	        customers.add(new cust(3, "chandu", "Delhi", 12345));
	        customers.add(new cust(4, "vara", "Chennai", 12345));
	        customers.add(new cust(5, "padma", "Hyderabad", 12345));

	        System.out.println("Customer list:");
	        for (cust customer : customers) {
	            System.out.println(customer);
	        }
	    }
	







}
