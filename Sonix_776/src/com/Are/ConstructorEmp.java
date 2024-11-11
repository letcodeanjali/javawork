package com.Are;

public class ConstructorEmp {
	

	 int eid, sal;

	 String eName;

	public ConstructorEmp(){ 

	

}

	public ConstructorEmp(int eid, int sal, String eName) {
		
		this.eid = eid;
		this.sal = sal;
		this.eName = eName;
	}

void show() {


System.out.println(eid+" "+eName+" "+sal);

 }

 public static void main(String[] args) {

	 ConstructorEmp  el = new ConstructorEmp  (1,9348, "harris");



	 ConstructorEmp e2 = new ConstructorEmp (2,6396, "joy");


	 ConstructorEmp e3 = new ConstructorEmp (3,4801, "komal");

	 ConstructorEmp e4 =new ConstructorEmp (4,5881, "preeti");



el.show(); e2.show(); e3.show(); e4.show();
}
 }