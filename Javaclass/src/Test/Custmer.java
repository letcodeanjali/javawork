package Test;
import java.util.*;

public class Custmer {
	
	
	    private int custId;
	    private String custName;
	    private String city;
	    private double billAmount;

	    public Custmer(int custId, String custName, String city, double billAmount) {
	        this.custId = custId;
	        this.custName = custName;
	        this.city = city;
	        this.billAmount = billAmount;
	    }

	    public int getCustId() {
	        return custId;
	    }

	    public String getCustName() {
	        return custName;
	    }

	    public String getCity() {
	        return city;
	    }

	    public double getBillAmount() {
	        return billAmount;
	    }

	    public static void main(String[] args) {
	        List<Custmer> customers = new ArrayList<>();

	       
	        customers.add(new Custmer(1, "Anjali", "Hyderbad", 100.50));
	        customers.add(new Custmer(2, "Padma", "banglore", 200.75));
	        customers.add(new Custmer(3, "vara", "Delhi", 150.25));
	        customers.add(new Custmer(4, "krishna", "Ahmedabad", 300.0));
	        customers.add(new Custmer(5, "teja", "Jaipur", 75.60));
	        customers.add(new Custmer(6, "lavanaya", "Seattle", 250.30));
	        customers.add(new Custmer(7, "ruthu", "Surat", 180.90));
	        customers.add(new Custmer(8, "aishu", "San Francisco", 220.45));
	        customers.add(new Custmer(9, "vishu", "Pune", 400.20));
	        customers.add(new Custmer(10, "pavan", "Kolkata", 120.80));

	       
	        Collections.sort(customers, Comparator.comparing(Custmer::getCustName));
	        System.out.println("Sorted by custName:");
	        for (Custmer customer : customers) {
	            System.out.println(customer.getCustName());
	        }

	       
	        Collections.sort(customers, Comparator.comparing(Custmer::getBillAmount));
	        System.out.println("\nSorted by billAmount:");
	        for (Custmer customer : customers) {
	            System.out.println(customer.getBillAmount());
	        }
	    }

	   
	    public String readEmail(String email) {
	        
	        return "Email read: " + email;
	    }
	}
