package com.javaLms;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataTest {

static Data data;
	
	@BeforeClass
	public static void setUp() {
		data = new Data();
	}
	
	@AfterClass
	public static void cleanUp() {
		data = null;
	}
	
	@Before
	public void show() {
		System.out.println("Test Case Started...");
	}
	
	@After
	public void end() {
		System.out.println("Test Case Ended...");
	}
	
	@Test
	public void testSayHello() {
		assertEquals("Welcome to Junit...", data.sayHello());
	}
	
	@Test
	public void testSum() {
		assertEquals(5, data.sum(2, 3));
	}

	@Test
	public void testMax3() {
		assertEquals(5, data.max3(2, 3, 5));
	}
	
	@Test
	public void testFact() {
		assertEquals(120, data.fact(5));
	}
}



