import java.util.ArrayList;
import java.util.Collections;

public class C {
	public static void main(String[] args) {
		ArrayList<Emp>a=new ArrayList<Emp>();
		a.add(new Emp(1,"tom",56));
		a.add(new Emp(2,"kishor",78));
		a.add(new Emp(3,"hanok",22));
		a.add(new Emp(4,"jeck",33));
		Collections.sort(a);
		for(Emp e:a)
			System.out.println(e.age+ "" +e.eName+ "" +e.eid);
		
	}

}
