package com.hashtables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class HashMapTests {
	private HashMap objectUnderTest;
	
	
	@Before
	public void setUp() {
		objectUnderTest = new HashMap(); // this will create a Hashmap of size 16 and 0.75 load factor by default
		objectUnderTest.put("one",1);
		objectUnderTest.put("two",2);
		objectUnderTest.put("three",3);
		objectUnderTest.put("four",4);
		objectUnderTest.put("five",5);
		objectUnderTest.put("six",6);
		objectUnderTest.put("seven",7);
		//Size Will grow size=8,(can be confirmed from debugger)
		objectUnderTest.put("eight",8);
	}

	@Test
	public void get() {
		assertNotNull(objectUnderTest.get("eight"));
		assertEquals("eight",objectUnderTest.get("eight").getKey());
	}
	
	@Test
	public void remove() {
		boolean removedObject= objectUnderTest.remove("eight");
		assertTrue(removedObject);
		assertNull(objectUnderTest.get("eight"));
		
	}
	
	@Test
	public void  put() {
		objectUnderTest.put("example" ,1);
		assertEquals(1,objectUnderTest.get("example").getValue());
		
	}
	
	@Test
	public void testResize() {
		// To do
		
	}
	
	
	

	

}
