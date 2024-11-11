package assignment;
import java.util.Scanner;

public class Max {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your two numbers: ");
		int n1=sc.nextInt(),n2=sc.nextInt();
		int sum=0;
		sc.close();
	
		
		System.out.print(n1+" "+n2);
		for(int i=2;i<10;i++) {
			sum=n1+n2;
			System.out.print(" "+sum);
			n1=n2;
			n2=sum;
		}

	}

}
