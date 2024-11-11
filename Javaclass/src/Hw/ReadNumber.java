package Hw;
import java.util.Scanner;


public class ReadNumber {
	
	
	    private static final String[] ones = {
	        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
	    };
	    private static final String[] teens = {
	        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
	    };
	    private static final String[] tens = {
	        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
	    };

	    public static String numberToWords(int num) {
	        if (num == 0) {
	            return "Zero";
	        }
	        if (num <= 9) {
	            return ones[num];
	        }
	        if (num <= 19) {
	            return teens[num - 10];
	        }
	        if (num <= 99) {
	            return tens[num / 10] + " " + ones[num % 10];
	        }
	        if (num <= 999) {
	            return ones[num / 100] + " Hundred " + numberToWords(num % 100);
	        }
	        return ones[num / 1000] + " Thousand " + numberToWords(num % 1000);
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number between 1 and 9999: ");
	        int number = scanner.nextInt();
	        scanner.close();

	        if (number < 1 || number > 9999) {
	            System.out.println("Number out of range.");
	        } else {
	            System.out.println(numberToWords(number));
	        }
	    }
	}



