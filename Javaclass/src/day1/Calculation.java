package day1;

public class Calculation {
	
	public void cal(int a, int b) {
		int c=a+b;
		System.out.println("sum is\n" +c);
	}
	public static void main(String[] args) {
		int a,b;
		a=5;
		b=7;
		Calculation obj=new Calculation();
		obj.cal(a,b); 
	}

}
