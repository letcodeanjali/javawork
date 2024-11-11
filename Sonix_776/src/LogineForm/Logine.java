package LogineForm;
import java.util.Scanner;


public class Logine {

	
		    public static void main(String[] args) {
		        
		        String userName = "anjali"; 
		        String Pword = "id2222"; 
		        Scanner sc = new Scanner(System.in);
		        System.out.print("UserName: ");
		        String name= sc.nextLine();
		         System.out.print("Password: ");
		        String Password = sc.nextLine();
		        
		        sc.close();
		         
		     if (userName.equals(name) && Pword.equals(Password)) {
		            System.out.println("Welcome " + userName);
		            System.out.println("Please check your credit");
		        } else {
		            System.out.println("You have entered the wrong username or password");
		        }
		    }
		}
	
		

		
		       
		        