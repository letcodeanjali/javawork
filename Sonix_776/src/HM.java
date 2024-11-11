import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HM {
	public static void main(String[] args) {
		Map<Integer,String>m=new HashMap<Integer,String> ();
		Map<Integer,String>n=new TreeMap<Integer,String> ();
		Map<Integer,String>o=new LinkedHashMap<Integer,String> ();
		
			
		m.put(5,null);
		m.put(4, "python");
		m.put(1, "java");
		m.put(2, "aws");
		m.put(3, "c++");
		n.put(5, "null");
		n.put(4, "apple");
		n.put(1, "orange");
		n.put(2, "banana");
		n.put(3, "grapes");
		o.put(null, "null");
		o.put(4, "C");
		o.put(1, "A");
		o.put(2, "S");
		o.put(3, "V");
		
		for(Map.Entry e:m.entrySet())
		
		{
			System.out.println(e.getKey()+"  "+e.getValue());
		}
		for(Map.Entry e:n.entrySet())
			
		{
			System.out.println(e.getKey()+"  "+e.getValue());
		}
		for(Map.Entry e:o.entrySet())
			
		{
			System.out.println(e.getKey()+"  "+e.getValue());
		}
		 /* Set s = m.entrySet();
		  Iterator i = s.iterator(); while(i.hasNext()) {
		  Map.Entry e = (Entry) i.next();
		 System.out.println(e.getKey()+"  "+e.getValue()); }
		 */
		
	}

}
