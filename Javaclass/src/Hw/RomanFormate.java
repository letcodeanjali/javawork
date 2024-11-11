package Hw;
import java.util.Scanner;


public class RomanFormate {
	
	
	    public static String intToRoman(int num) {
	        if (num < 1 || num > 1000) {
	            return "Number out of range";
	        }

	        String[] romanThousands = {"", "M", "MM", "MMM"};
	        String[] romanHundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	        String[] romanTens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	        String[] romanOnes = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

	        return romanThousands[num / 1000] +
	               romanHundreds[(num % 1000) / 100] +
	               romanTens[(num % 100) / 10] +
	               romanOnes[num % 10];
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number between 1 and 1000: ");
	        int number = scanner.nextInt();
	        scanner.close();

	        System.out.println("Roman numeral: " + intToRoman(number));
	    }
	}



