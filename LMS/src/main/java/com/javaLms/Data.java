package com.javaLms;

public class Data {

	public String sayHello() {
		return "Welcome to Junit...";
	}
	
	public int sum(int a, int b) {
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
	
	public int fact(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * fact(n-1);
		}
	}
}
