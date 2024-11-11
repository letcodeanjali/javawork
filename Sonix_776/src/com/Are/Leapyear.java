package com.Are;
import java.util.Scanner;
public class Leapyear {
public static void main(String[] args) {
	Scanner a=new Scanner(System.in);
	System.out.println("year number");
	int year=a.nextInt();
	a.close();
	boolean leap=false;
	if(year%4==0)
		if(year%100==0)
			if(year%400==0)
				leap=true;
			else
				leap=false;
		else
			leap=true;
	else
		leap=false;
	if(leap)
		System.out.println(year+" is a leap year");
	else 
		System.out.println(year+" is not a leap year");
}
}
