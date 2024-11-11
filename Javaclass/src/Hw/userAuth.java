package Hw;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;


public class userAuth {
	

	
	
	    public static void main(String[] args) {
	        Map<String, String> userData = new Hashtable<>();
	        userData.put("Chandra", "Sekhar");
	        userData.put("Rama", "Anjaneyulu");
	        userData.put("Anil", "Varma");
	        userData.put("Padma", "Anjali");
	        userData.put("Satish", "Gavini");

	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter UserName");
	        String user = sc.next();
	        System.out.println("Enter Password ");
	        String pwd = sc.next();

	        if (userData.containsKey(user)) {
	            String storedPwd = userData.get(user);
	            if (storedPwd.equals(pwd)) {
	                System.out.println("Authentication Successful!");
	            } else {
	                System.out.println("Incorrect Password!");
	            }
	        } else {
	            System.out.println("User not found!");
	        }
	    }
	}


