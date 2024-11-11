import java.util.ArrayList;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Set;

public class ListSet {
	
	    public static void main(String[] args) {
	       
	       List<String> myList = new ArrayList<>();

	        
	        myList.add("Apple");
	        myList.add("Banana");
	        myList.add("Cherry");
	        myList.add("Apple"); 
	        myList.add("Apple"); 
	        myList.add(null); 
	        myList.add(null); 

	        
	        System.out.println("List elements: " + myList);

	        
	        Set<String> mySet = new HashSet<>();

	        
	        mySet.add("Apple");
	        mySet.add("Banana");
	        mySet.add("Cherry");
	        mySet.add("Apple");
	        mySet.add(null); 
	        mySet.add(null); 

	        
	        System.out.println("Set elements: " + mySet);

	       
	       
	    }
}
	
	    