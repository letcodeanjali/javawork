package com.Are;


import java.util.ArrayList;
import java.util.HashSet;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class AA {
	public static void main(String[] args) {
		HashSet<Prod>l=new HashSet<Prod>();
		TreeSet<Prod>m=new TreeSet<Prod>();
		LinkedHashSet<Prod> n= new LinkedHashSet<Prod>();
		ArrayList<Prod>t=new ArrayList<Prod>();
		Prod p1=new Prod("bag",1,457);
		Prod p2=new Prod("box",2,456);
		Prod p3=new Prod("clock",3,699);
		Prod p4=new Prod("pen",4,799);
		Prod p5=new Prod("books",5,674);
		l.add(p4);
		l.add(p3);
		l.add(p2);
		l.add(p1);
		l.add(p5);
		m.add(p4);
		m.add(p3);
		m.add(p2);
		m.add(p1);
		m.add(p5);
		n.add(p4);
		n.add(p3);
		n.add(p2);
		n.add(p1);
		n.add(p5);
		t.add(p4);
		t.add(p3);
		t.add(p2);
		t.add(p1);
		t.add(p5);
		
		
		for(Prod p:l)
			System.out.println(p.pid+""+p.pName+""+p.cost);
		for(Prod p:m)
			System.out.println(p.pid+""+p.pName+""+p.cost);
		for(Prod p:n)
			System.out.println(p.pid+""+p.pName+""+p.cost);
		for(Prod p:t)
			System.out.println(p.pid+""+p.pName+""+p.cost);
	}

}
