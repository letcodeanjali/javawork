
import java.util.Comparator;


public class Reversorder implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof String && o2 instanceof String)
	
		return ((String)o1).compareTo((String)o2);
		else 
			throw new ClassCastException();

}
}


	
	

