package com.hashtables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.hashtables.LinkedList;
import com.hashtables.Node;

public class LinkedListTest {
	private LinkedList objectUnderTest;
	private Node node1;
	
	@Before
	public void setup() {
		node1 = new Node("one",1);
		
		objectUnderTest = new LinkedList(node1);
		
		Node node2 = new Node("two",2);
		Node node3 = new Node("three",3);
		Node node4 = new Node("four",4);
		Node node5 = new Node("five",5);
		
		objectUnderTest.add(node2);
		objectUnderTest.add(node3);
		objectUnderTest.add(node4);
		objectUnderTest.add(node5);
		
	}
	
	@Test
	public void getSize() {
		assertEquals(5,objectUnderTest.getSize());
		
	}
	
	@Test
	public void getNode() {
		assertEquals(objectUnderTest.getNode("two").getValue(),2);
		assertEquals(objectUnderTest.getNode(1).getValue(),2);
		
	}
	
	@Test
	public void remove() {
		objectUnderTest.remove(node1);
		Node result=objectUnderTest.getNode("one");
		assertNull(result);
		
		objectUnderTest.remove(0);
		result = objectUnderTest.getNode(0);
		assertNotEquals(result.getValue(),node1.getValue());

	}
	
	@Test
	public void replace() {
		
		Node replaceNode = new Node("six",6);
		objectUnderTest.replace(2, replaceNode);
		assertEquals(objectUnderTest.getNode(2).getValue() , replaceNode.getValue());
		 
		Node replaceNewNode = new Node("seven",7);
		objectUnderTest.replace(replaceNode, replaceNewNode);
		
		assertEquals(objectUnderTest.getNode(2).getValue() , replaceNewNode.getValue());
		
		
		
	}
	
	

}
