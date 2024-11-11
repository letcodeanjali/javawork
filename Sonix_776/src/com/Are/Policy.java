package com.Are;
abstract class Insurance{
	abstract double getinsure();
	double amt=100;

	
}
class child extends Insurance
{
	@Override
	public double getinsure() {
	return 1.0489*amt;
}
}
class retirement extends Insurance
{
	@Override
	public double getinsure() {
	return 1.1204*amt;
}
}
class accidental extends Insurance
{
	@Override
	public double getinsure() {
	return 1.3257*amt;
}
}
class mortgage extends Insurance
{
	@Override
	public double getinsure() {
	return 1.2718*amt;
}
}

public class Policy {
	
	

	public static void main(String[] args) {
		
		
		child p=new child();
		System.out.println("child offered.."+p.getinsure());
		
		retirement q=new retirement();
		System.out.println("retirement"+q.getinsure());
		 accidental r=new accidental();
		System.out.println("accidental."+r.getinsure());
		mortgage s=new mortgage();
		System.out.println("mortgage .."+s.getinsure());
	}

	
	}
