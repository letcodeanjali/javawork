package day1;
/***
 * java program to convert the celsiue to fahrenheit
 */
public class CtoF {
	public void calc(double c) {
		double f=((9*c)/5) + 32;
		System.out.println("fahrenheit value" +f);
	
	}
	public static void main(String[] args) {
		double c=37;
		CtoF obj=new CtoF();
		obj.calc(c);
	}

}
