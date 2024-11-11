package assignment;

public class ExceptionHandling {
	
	
	    public static void main(String[] args) {
	        
	        try {
	            int result = 5 / 0; 
	        } catch (ArithmeticException e) {
	            System.out.println("ArithmeticException : " + e.getMessage());
	        }

	      
	        try {
	            String text = null;
	            int length = text.length(); 
	        } catch (NullPointerException e) {
	            System.out.println("NullPointerException: " + e.getMessage());
	        }

	        
	        try {
	            int[] arr = { 1, 2, 3 };
	            int value = arr[5]; 
	        } catch (ArrayIndexOutOfBoundsException e) {
	            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
	        }

	        
	        try {
	            java.io.FileReader fileReader = new java.io.FileReader("nonexistent.txt");
	        } catch (java.io.FileNotFoundException e) {
	            System.out.println("FileNotFoundException: " + e.getMessage());
	            
	        }
	    finally { 
	    	System.out.println("finally...");
	    }
}
	    }