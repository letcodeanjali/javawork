package assignment;
import java.util.Scanner;

public class eversedString {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Enter String ");
    	 String str = sc.nextLine();    
         
         String reversedStr = "";    
             sc.close();
           
         for(int i = str.length()-1; i >= 0; i--){    
             reversedStr = reversedStr + str.charAt(i);    
         }    
             
         System.out.println("Original string: " + str);    
            
         System.out.println("Reverse of given string: " + reversedStr);

	}

}
