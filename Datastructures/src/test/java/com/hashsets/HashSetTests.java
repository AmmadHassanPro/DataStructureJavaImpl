package com.hashsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.Sets.HashSet;
import com.nodes.Node;

public class HashSetTests {
	private HashSet objectUnderTest = new HashSet();
	
	@Test
	public void testAdd() {
		objectUnderTest = new HashSet();
		Node node1 = new Node("Test Node 1", 1);
		Node node2 = new Node("Test Node 2", 2);
		Node node3 = new Node("Test Node 3", 3);
		Node node4 = new Node("Test Node 4", 4);
		
		objectUnderTest.add(node1);
		objectUnderTest.add(node2);
		objectUnderTest.add(node3);
		objectUnderTest.add(node4);
		
		assertEquals(4, objectUnderTest.getCount());
		
	}
	
	@Test
	public void testRemove() {
		objectUnderTest  = new HashSet();
		Node node1 = new Node("Test Node 1", 1);
		Node node2 = new Node("Test Node 2", 2);
		Node node3 = new Node("Test Node 3", 3);
		Node node4 = new Node("Test Node 4", 4);
		
		objectUnderTest.add(node1);
		objectUnderTest.add(node2);
		objectUnderTest.add(node3);
		objectUnderTest.add(node4);
		
		assertTrue(objectUnderTest.remove(node4));
		assertEquals(3,objectUnderTest.getCount());
	}
	
	@Test
	public void testDuplicates(){
		objectUnderTest  = new HashSet();
		Node node1 = new Node("Test Node 1", 1);
		Node node2 = new Node("Test Node 2", 2);
		Node node3 = new Node("Test Node 3", 3);
		Node node4 = new Node("Test Node 4", 4);
		Node duplicateNode = node4;
		
		
		objectUnderTest.add(node1);
		objectUnderTest.add(node2);
		objectUnderTest.add(node3);
		objectUnderTest.add(node4);
		objectUnderTest.add(duplicateNode);
		
		assertEquals(4,objectUnderTest.getCount());
		
	}
	

}
