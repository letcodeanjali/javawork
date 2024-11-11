import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashSet;
public class Main {
	
	    public static void main(String[] args) {
	        
	        ArrayList<Integer> al = new ArrayList<>();
	        al.add(2);
	        al.add(9);
	       al.add(3);
	        al.add(8); 
	        al.add(5);
	       al.add(3);

	        
	        Stack<Integer> s = new Stack<>();
	        HashSet<Integer> st = new HashSet<>();
            for (Integer e : al) {
	            if (!st.contains(e)) {
	                s.push(e);
	                st.add(e);
	            }
	        }
	        while (!s.isEmpty()) {
	            System.out.println("Popped: " + s.pop());
	        }
	    }
	}


