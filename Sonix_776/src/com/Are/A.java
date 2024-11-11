package com.Are;

import java.util.Iterator;
import java.util.LinkedHashSet;
//import java.util.HashSet;
//import java.util.TreeSet;

public class A {
	

	public static void main(String[] args) {
		//HashSet<String>h=new HashSet<String>();
		//TreeSet<String>h=new TreeSet<String>();
		LinkedHashSet<String>h=new LinkedHashSet<String>();
	h.add("jon");
	h.add("tom");
	h.add("min");
	h.add("tony");
	Iterator<String>i=h.iterator();
	System.out.println(h);
	
		
	}

}
