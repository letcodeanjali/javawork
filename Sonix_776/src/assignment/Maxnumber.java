package assignment;

public class Maxnumber {
	public static void main(String[] args) {
		
	
	int arr[]= {1,3,5,7,10,22,45};
	int max=arr[0];
	
	for(int i=0; i<arr.length;i++) {
		if(arr[i]>max) 
			max=arr[i];
	}
	System.out.println("Max number in an array: "+max);

}
}