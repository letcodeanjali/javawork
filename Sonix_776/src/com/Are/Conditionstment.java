package com.Are;

public class Conditionstment {

	public static void main(String[] args) { 

	

	 String Sname="anjali";

	int m1=30,m2=30,m3=35, total, SId=777666;
	double avg;
	total=(m1+m2+m3);
	  avg=total/3;
	

    System.out.println("Student Name: "+Sname);
	 System.out.println("Student ID: "+SId);

	 System.out.println("Marks m1: "+m1);
	  System.out.println("Marks m2: "+m2);

	System.out.println("Marks m3: "+m3); 
	 System.out.println("Marks total: "+total);

	System.out.println("Marks Average: "+avg); 

	 if (avg>60) { System.out.println(" First Class");}
	 
	

	else if	(avg>=50){ System.out.println(" Second Class");}
	
	 else {

	if (avg>=35) System.out.println("third class");
	 else {
		 System.out.println("studient failed");
	 }
	 }
	}
}
