package RegistationFome;


import java.util.Scanner;



public class Registation {

	
		public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Registration Form");
	        System.out.println("-----------------");

	        System.out.print("Enter your First Name: ");
	        String Firstname = scanner.nextLine();

	        System.out.print("Enter your Last Name: ");
	        String Lastname = scanner.nextLine();

	        System.out.print("Enter your Date Of Birth: ");
	        String DOB = scanner.nextLine();
	        
	        System.out.print("Enter your Mobile Number:");
	        String Mobile=scanner.nextLine();
	        
	        System.out.print("Enter your ID Proof:");
	        String IDProof=scanner.nextLine();
	        
	        System.out.print("Enter your Password:");
	        String Password=scanner.nextLine();
	        
	        System.out.print("Enter your User Name:");
	        String Username=scanner.nextLine();
	        
	        
	        

	        System.out.println("\nRegistration Successful!");
	        System.out.println("First Name: " + Firstname);
	        System.out.println("Last Name: " + Lastname);
	        System.out.println("Date Of Birth: " + DOB);
	        System.out.println("Mobile Number:"+Mobile);
	        System.out.println("ID Proof:"+IDProof);
	        System.out.println("Password:"+Password);
	        System.out.println("User Name:"+Username);
	        

	        scanner.close();
	    


		

}
}
