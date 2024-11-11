package assignment;
import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter the Number: ");
		int n=scan.nextInt();
		int num=n,rev=0;
		while(n!=0)
		{
			rev=rev*10+n%10;
			n=n/10;
		}
		
		if(num==rev) {
			System.out.println("Given number "+num+" is a Palindrome Number");
		}else
		{
			System.out.println("Reversed number: "+rev);
			System.out.println("Given number is not a Palindrome Number");
		}
scan.close();
	}

}
