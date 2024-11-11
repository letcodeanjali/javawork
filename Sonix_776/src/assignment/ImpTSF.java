package assignment;


public class ImpTSF {
	 private static int instancecount = 5; 

	    private final int instanceNumber = 6;



	    public static void main(String[] args) {
	        ImpTSF obj1 = new ImpTSF();
	        ImpTSF obj2 = new ImpTSF();
	        ImpTSF obj3 = new ImpTSF();

	       
	        System.out.println("Object 1 Instance Number: " + obj1.getInstanceNumber());
	        System.out.println("Object 2 Instance Number: " + obj2.getInstanceNumber());
	        System.out.println("Object 3 Instance Number: " + obj3.getInstanceNumber());

	        
	        System.out.println("Total Instances Created: " + ImpTSF.getInstanceCount());
	    }

	    public int getInstanceNumber() {
	        return this.instanceNumber; 
	    }

	    public static int getInstanceCount() {
	        return instancecount; 
	    }
	}