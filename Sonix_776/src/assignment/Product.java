package assignment;
import java.util.Scanner;

public class Product {
public static void main(String[] args) {
	Scanner pa = new Scanner(System.in);
	System.out.println("Enter Product ID: ");
	int pid=pa.nextInt();
	System.out.println("Enter Product Name: ");
	pa.nextLine();
	String pname=pa.nextLine();
	System.out.println("Enter Product Price: ");
	double pprice=pa.nextDouble();
	System.out.println("Enter Quantity: ");
	int qty=pa.nextInt();
	System.out.println("Enter Stock: ");
	int stk=pa.nextInt();
	double tcost=pprice*qty,
			gst=0.0,dis=0.0;
	pa.close();
	
	
	 if (tcost >= 25000) {
            dis = 0.12 * tcost;
        } else if (tcost >= 10000) {
            dis = 0.08 * tcost;
        } else {
            gst = 0.185 * tcost;
        }
	 
	 double fcost=tcost-dis+gst;
	 
	 System.out.println("Product Id: "+pid);
	 System.out.println("Product Name: "+pname);
	 System.out.println("Total Price: "+tcost);
	 System.out.println("Discount Aquired: "+qty);
	 System.out.println("GST: "+gst);
	 System.out.println("Final Cost: "+fcost);
	
}
}
