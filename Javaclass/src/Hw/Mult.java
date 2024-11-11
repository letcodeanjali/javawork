package Hw;
import java.math.*;
import java.util.*;


public class Mult {
	
	        public static void main(String[] args){
	        Scanner input=new Scanner(System.in);
	        System.out.print("Enter Number: ");
	        BigInteger bi=input.nextBigInteger();
	        String strSum = bi.toString();
	        BigInteger num=new BigInteger("1");
	        for(int i = 0;i < strSum.length(); i++){
	        char ch=strSum.charAt(i);
	        num=num.multiply(new BigInteger(Character.toString(ch)));
	        }
	        System.out.println(num);
	        }
	}
	
	      


