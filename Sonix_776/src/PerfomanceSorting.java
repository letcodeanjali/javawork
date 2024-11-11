import java.util.TreeSet;

public class PerfomanceSorting {
	public static void main(String[] args) {
		TreeSet<EQPLC> perfom= new TreeSet<EQPLC>();
		EQPLC p1= new EQPLC(521,"P1","Chandu", 4321, "Traveling", 90785.96 ,4.5 ,3.4 ,5.0 ,4.2);
		EQPLC p2= new EQPLC(522,"P1","Anjali", 4322, "Traveling", 100785.96 ,4.0 ,5.4 ,5.0 ,4.3);
		EQPLC p3= new EQPLC(523,"U1","Sushma", 4323, "Banking", 89985.96 ,3.5 ,3.4 ,5.0 ,4.1);
		EQPLC p4= new EQPLC(524,"U1","Rajesh", 4324, "Banking", 80885.96 ,5.5 ,3.4 ,4.0 ,4.5);
		EQPLC p5= new EQPLC(525,"P1","Vara", 4325, "Traveling", 80785.96 ,3.5 ,3.4 ,3.0 ,4.0);
		EQPLC p6= new EQPLC(525,"U1","Sireesha", 4325, "Banking", 85785.96 ,5.5 ,4.4 ,3.0 ,4.0);
		
		
		perfom.add(p1);
		perfom.add(p2);
		perfom.add(p3);
		perfom.add(p4);
		perfom.add(p5);
		perfom.add(p6);
		
		System.out.println("Sorted based on performance ");  
		System.out.println();
		for(EQPLC p:perfom) {
			System.out.println(p.getRate());
			System.out.println(p.eid);
			System.out.println(p.getBand());
			System.out.println(p.eName);
			System.out.println(p.pid);
			System.out.println(p.pName);
	  		System.out.println(p.getBasic());
			System.out.println(p.getBonus());
			System.out.println(p.getNet());
			System.out.println(p.gettax());
			System.out.println(p.getSalary());
			System.out.println();
			
			
	}
		
	}

}
