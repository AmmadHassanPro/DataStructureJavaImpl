package com.Stacks;

import com.nodes.DoubleNode;

/*
 * This class represents Stack implementing with Double Linked List
 */
public class Stack {
	
	private DoubleNode pointer;
	private int count=0;
	
	
	public void push(DoubleNode obj) {
	
		if(pointer==null) {
			pointer=obj;
			count++;
			return;
		}
		
		pointer.setNext(obj);
		obj.setPrev(pointer);
		obj.setNext(null);
		pointer = obj;
		count++;
		
	}
	
	public DoubleNode pop() {
		
		DoubleNode returnThisObj = pointer;
		DoubleNode previousObj = pointer.getPrev();
		pointer = previousObj;
		pointer.setNext(null);
		count--;
		return returnThisObj;
		
		
	}
	
	
	public int getCount() {
		return count;
		
	}
	

}
