import java.util.HashMap;
import java.util.HashSet;

public class PushSIvalues {
	public static void main(String[] args) {
		HashSet<Integer>h1= new HashSet<Integer>();
		HashSet<String>h2= new HashSet<String>();
		h1.add(97);
		h1.add(42);
		h1.add(81);
		h1.add(74);
		h2.add("java");
		h2.add("python");
		h2.add("html");
		h2.add("css");
		 HashMap<Integer, String> hashMap = new HashMap<>();

	        // Iterate through the HashSet and create the mappings
	        if (h2.size() == h2.size()) {
	            int i = 0;
	            for (Integer key : h1) {
	                String value = h2.toArray(new String[0])[i];
	                hashMap.put(key, value);
	                i++;
	            }
	        } else {
	            System.out.println("HashSet sizes don't match.");
	        }

	        // Print the HashMap
	        for (Integer key : hashMap.keySet()) {
	            String value = hashMap.get(key);
	            System.out.println(key + " -> " + value);
	        }
	}
}
	    
	
		
	


