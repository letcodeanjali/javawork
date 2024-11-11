import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;

public class S {
	public static void main(String[] args) {
		ArrayList<String>a=new ArrayList<String>();
		a.add("milk");
		a.add("bun");
		a.add("eggs");
		a.add("bananes");
		a.add("chipes");
		Iterator<String>i=a.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		//using sorting 
		System.out.println("Sorting elements...");
		Collections.sort(a);
		for(Object O:a)
			System.out.println(O);
	}


}
