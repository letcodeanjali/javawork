package com.javaJunit;

public class Demo {
public String sayHello() {
	return "welcome to Junite testing";
}
public int sum(int a,int b) {
	return a+b;
}
public int max3(int a, int b, int c) {
	int m = a;
	if (m < b) {
		m = b;
	}
	if (m < c) {
		m = c;
	}
	return m;
}
}