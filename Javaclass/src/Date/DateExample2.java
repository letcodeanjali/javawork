package Date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateExample2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String startDate,endDate;
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Enter Start Date(yyyy-MM-dd)");
		startDate=sc.next();
		System.out.println("Enter the end date(yyyy-MM-dd)");
		endDate=sc.next();
		try {
			Date Sdate=sdf.parse(startDate);
			Date edate=sdf.parse(startDate);
			long ms=edate.getTime()-Sdate.getTime();
			long Days=(ms)/(1000*60*60*24);
			System.out.println(Days);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
	}

}
