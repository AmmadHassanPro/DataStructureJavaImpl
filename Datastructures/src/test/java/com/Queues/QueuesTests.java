package com.Queues;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nodes.DoubleNode;

public class QueuesTests {

	private Queue objectUnderTest = new Queue();
	
	@Test
	public void testEnqueue() {
		
		DoubleNode node1 = new DoubleNode();
		node1.setData(10);
		DoubleNode node2 = new DoubleNode();
		node2.setData(12);
		objectUnderTest.Enqueue(node1);
		objectUnderTest.Enqueue(node2);
		assertEquals(objectUnderTest.getCount(),2);
	}
	
	@Test
	public void testDequeue() {
		
		DoubleNode node1 = new DoubleNode();
		node1.setData(10);
		DoubleNode node2 = new DoubleNode();
		node2.setData(12);
		objectUnderTest.Enqueue(node1);
		objectUnderTest.Enqueue(node2);
		DoubleNode node = objectUnderTest.Dequeue();
		assertEquals(objectUnderTest.getCount(),1);
		
		assertEquals(node.getData(),node1.getData());
		
	
	}
	
}
