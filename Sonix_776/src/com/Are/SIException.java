package com.Are;
import java.util.Scanner;

public class SIException{
	public static double calcualteSI(double principal,double rate,double time ,String msg)throws SimpleInterestException {
double simpleInterest = principal*rate*time/100;
		
		if (simpleInterest >= 5000) {
		    throw new SimpleInterestException("simple interest is too huge");
		}
	 return simpleInterest;
	 }
		
	    		
	    
			public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter principal amount value ");
				double principal = scanner.nextDouble();	
				System.out.println("Enter rate value");
				double rate = scanner.nextDouble();
				System.out.println("Enter time value");
				double time = scanner.nextDouble();
				scanner.close();
				
			
	
	        try  {
				double simpleInterest=calcualteSI(principal,rate,time,"simple intrest is too huge");
      System.out.println("The simple interest is: " + simpleInterest);
	        
	        }catch(SimpleInterestException e){
	        	System.err.println("Error: "+ e.getMessage());
	        }
	        }
}
	
	
	    
	
	
	   