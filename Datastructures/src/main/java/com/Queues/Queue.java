package com.Queues;

import com.nodes.DoubleNode;

public class Queue {
	
	private DoubleNode toppointer;
	private DoubleNode basepointer;
	private int count=0;
	
	
	public void Enqueue(DoubleNode obj) {
		if(toppointer==null) {
			toppointer = obj;
			basepointer = obj;
			count++;
			return;
			
		}
		toppointer.setNext(obj);
		obj.setNext(null);
		toppointer = obj;
		count++;
		
		
	}
	
	public DoubleNode Dequeue() {
		if(basepointer==null) {
			return null;
		}
		
		DoubleNode returnThis = basepointer;
		//Moving base Pointer to next
		DoubleNode nextElement = basepointer.getNext();
		nextElement.setPrev(null);
		basepointer = nextElement;
		count--;
		return returnThis;

	}
	
	public int getCount() {
		return count;
	}
	
	

}
