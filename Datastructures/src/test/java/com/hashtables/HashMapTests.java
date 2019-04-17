package com.hashtables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Will be placing alphabets in front of method name to make sure they run in specific order
public class HashMapTests {
	private HashMap objectUnderTest;
	private Class testClass;
	private 	Field hashArraySizeField;
	
	
	
	@Before
	public void setUp() {
		objectUnderTest = new HashMap(); // this will create a Hashmap of size 16 and 0.75 load factor by default
		
	
		testClass =  objectUnderTest.getClass();
		try {
			hashArraySizeField = testClass.getDeclaredField("hashArraySize");
			hashArraySizeField.setAccessible(true);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		objectUnderTest.put("one",1);
		objectUnderTest.put("two",2);
		objectUnderTest.put("three",3);
		objectUnderTest.put("four",4);
		objectUnderTest.put("five",5);
		objectUnderTest.put("six",6);
		objectUnderTest.put("seven",7);
		
		
		
	}


	/*
	 *This test will determine if the hashmap is resizing (increasing) as per its load factor 
	 */
	@Test
	public void atestIncreaseSize()  {
		//Size Will grow size=8,(can be confirmed from debugger)
		
		
	
		int SIZE_BEFORE_RESIZE=0,SIZE_AFTER_RESIZE=0;
		try {
			
			SIZE_BEFORE_RESIZE =  hashArraySizeField.getInt(objectUnderTest);
		
			objectUnderTest.put("eight",8);
			objectUnderTest.put("nine",9);
			objectUnderTest.put("ten",10);
			objectUnderTest.put("eleven",11);
			objectUnderTest.put("twelve",12);
			// It will resize from here
			objectUnderTest.put("thirteen",13);
			
			
			SIZE_AFTER_RESIZE = hashArraySizeField.getInt(objectUnderTest);
		} catch ( SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		assertTrue(SIZE_AFTER_RESIZE>SIZE_BEFORE_RESIZE);
		
	}
	/*
	 *This test will determine if the hashmap is resizing (decreasing) as per its load factor 
	 */
	@Test
	public void btestDecrease() {
		int SIZE_BEFORE_RESIZE=0, SIZE_AFTER_RESIZE=0;
		try {
			
			SIZE_BEFORE_RESIZE =  hashArraySizeField.getInt(objectUnderTest);
		
			// It will resize from here
			objectUnderTest.remove("thirteen");
			
			
			SIZE_AFTER_RESIZE = hashArraySizeField.getInt(objectUnderTest);
		} catch ( SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(SIZE_AFTER_RESIZE<SIZE_BEFORE_RESIZE);
		
	
	}
	
	@Test
	public void cget() {
		assertNotNull(objectUnderTest.get("one"));
		assertEquals("one",objectUnderTest.get("one").getKey());
	}
	@Test
	public void dremove() {
		boolean removedObject= objectUnderTest.remove("eight");
		assertTrue(removedObject);
		assertNull(objectUnderTest.get("eight"));
		
	}
	
	@Test
	public void  eput() {
		objectUnderTest.put("example" ,1);
		assertEquals(1,objectUnderTest.get("example").getValue());
		
	}
	
	
	
	
	

	

}
