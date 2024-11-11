package Date;
//create a date

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

 public static void main(String[] args) {
	 Date date = new Date();
	 System.out.println(date);
	SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-YYYY");
	System.out.println(sdf.format(date));
}
  
}
