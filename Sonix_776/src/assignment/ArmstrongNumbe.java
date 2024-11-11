package assignment;
import java.util.Scanner;

public class ArmstrongNumbe {
	public static void main(String[] args) {
		
	
	
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter the number: ");
	int i=sc.nextInt();
	sc.close();
	int num=i,r, sum=0;
	
	while(i>0) {
	r=i%10;
	i=i/10;
	sum=sum+(r*r*r);
	}
	if(num==sum) {System.out.print(num+" is an Armstrong number: ");}
	else {System.out.print(num+" is not an Armstrong number, because we got "+sum);}

}
}
