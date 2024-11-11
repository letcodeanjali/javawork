package Date;
//convert the date

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateExample1 {
	public static void main(String[] args) {
		String strDate;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter date(MM-dd-yyyy) ");
		strDate=sc.next();
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
		try {
			Date date=sdf.parse(strDate);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
