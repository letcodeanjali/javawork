import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class R {
	
		public static void main(String[] args) {
			String ename[]= {"Steve","jackson","thomson","nelson","robinson"};
			TreeSet t=new TreeSet<R>(new Reversorder());
			
			t.addAll(Arrays.asList(ename));
			Iterator i=t.iterator();
			while(i.hasNext());
			{
				System.out.println(i.next());
			}
			

		}
}
