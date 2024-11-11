package com.Are;

public class Staticemp {
	int eid; 
	String eName;

	static String org= "ABC"; 
	public Staticemp() {
		
	}



	public Staticemp(int eid, String eName) 
	{

	super();

	this.eid =eid; 
	this.eName= eName;


	}

	 static void chg ()
	 {
		 org="SONIX";
	 }
	 void show()
	 {
		 System.out.println(eid+""+eName+""+org);
	 }
	 public static void main(String[] args) {
		chg();
		Staticemp e1=new Staticemp(1,"anjali");
		Staticemp e2=new Staticemp(2,"manju");
		Staticemp e3=new Staticemp(3,"tomey");
		Staticemp e4=new Staticemp(4,"jungkook");
		e1.show();
		e2.show();
		e3.show();
		e4.show();
		
	}
	

}

