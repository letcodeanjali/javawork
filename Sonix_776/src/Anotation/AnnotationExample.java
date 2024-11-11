package Anotation;


import java.util.ArrayList;

public class AnnotationExample {
	  @Override
	    public String toString() {
	        return "This is the overridden toString method.";
	    }

	    @Deprecated
	    public void deprecatedMethod() {
	        System.out.println("This method is deprecated.");
	    }

	    @SuppressWarnings("unchecked")
	    public void suppressedWarning() {
	        // Suppressing unchecked warning for this specific line
	        ArrayList list = new ArrayList();
	        list.add("Item 1");
	    }

	    public static void main(String[] args) {
	        AnnotationExample example = new AnnotationExample();

	        // Using the @Override annotation
	        System.out.println(example);

	        // Using the @Deprecated annotation
	        example.deprecatedMethod();

	        // Using the @SuppressWarnings annotation
	        example.suppressedWarning();
	    }
	}


