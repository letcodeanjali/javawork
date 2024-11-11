package Hw;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddMonths {
	
	
	    public static void main(String[] args) {
	        
	        String dateStr = "August 12 2024";
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
	        LocalDate startDate = LocalDate.parse(dateStr, formatter);

	        
	        LocalDate newDate = startDate.plusMonths(3);

	        System.out.println("Original date: " + startDate.format(formatter));
	        System.out.println("New date after adding 3 months: " + newDate.format(formatter));
	    }
	}

