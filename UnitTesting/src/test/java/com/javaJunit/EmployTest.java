package com.javaJunit;


import static org.junit.Assert.*;

import org.junit.Test;

public class EmployTest {
	@Test
	public void testToString() {
		Employ empnew = new Employ(1, "Chandra", "Male", "Java", 
				"Developer", 98823);
		String result = "Employ [empno=1, name=Chandra, gender=Male, dept=Java, "
				+ "desig=Developer, basic=98823.0]";
		assertEquals(result, empnew.toString());
	}
	
	@Test
	public void testConstructor() {
		Employ employ = new Employ();
		assertNotNull(employ);
		Employ empnew = new Employ(1, "Chandra", "Male", "Java", 
				"Developer", 98823);
		assertEquals(1, empnew.getEmpno());
		assertEquals("Chandra", empnew.getName());
		assertEquals("Male", empnew.getGender());
		assertEquals("Java", empnew.getDept());
		assertEquals("Developer", empnew.getDesig());
		assertEquals(98823, empnew.getBasic(), 0);
	}
	
	@Test
	public void testGettersAndSetters() {
		Employ employ = new Employ();
		employ.setEmpno(1);
		employ.setName("Chandra");
		employ.setGender("Male");
		employ.setDept("Java");
		employ.setDesig("Programmer");
		employ.setBasic(97772);
		
		assertEquals(1, employ.getEmpno());
		assertEquals("Chandra", employ.getName());
		assertEquals("Male", employ.getGender());
		assertEquals("Java", employ.getDept());
		assertEquals("Programmer", employ.getDesig());
		assertEquals(97772, employ.getBasic(), 0);
	}

}