package com.javaJunit;

import static org.junit.Assert.*;

import org.junit.Test;

public class DemoTest {
	@Test
	public void testsum() {
		Demo demo=new Demo();
		assertEquals(5,demo.sum(2,3));
	}

	@Test
	public void testsayHello() {
		Demo demo=new Demo();
		assertEquals("welcome to Junite testing",demo.sayHello());
	}
	@Test
	public void testMax3() {
		Demo demo = new Demo();
		assertEquals(5, demo.max3(5, 3, 2));
		assertEquals(5, demo.max3(3, 5, 2));
		assertEquals(5, demo.max3(2, 3, 5));
	}


}
