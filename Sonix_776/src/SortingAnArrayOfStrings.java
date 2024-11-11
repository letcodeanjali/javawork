
public class SortingAnArrayOfStrings {
	public static void main(String[] args) {
		String[] names = {"John", "David", "Abram","William","Mccullum"};
		java.util.Collections.sort(java.util.Arrays.asList(names), new java.util.Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        
		        return s1.charAt(1) - s2.charAt(1);
		    }  
		});

		for (String name : names) 
			System.out.println(name);	
	}}



