package com.Stacks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nodes.DoubleNode;

public class StacksTests {
	
	private Stack objUnderTest = new Stack();
	
	@Test
	public void testPush() {
		DoubleNode node1 = new DoubleNode();
		DoubleNode node2 = new DoubleNode();
		DoubleNode node3 = new DoubleNode();
		
		node1.setData(10);
		node2.setData(11);
		node3.setData(12);
		
		objUnderTest.push(node1);
		objUnderTest.push(node2);
		
		assertEquals(2,objUnderTest.getCount());
	}
	
	@Test
	public void testPop() {
		DoubleNode node1 = new DoubleNode();
		DoubleNode node2 = new DoubleNode();
		DoubleNode node3 = new DoubleNode();
		objUnderTest.push(node1);
		objUnderTest.push(node2);
		objUnderTest.push(node3);
		
		
		assertEquals(objUnderTest.pop(), node3);
		assertEquals(2,objUnderTest.getCount());
		
		
	}
	

}
