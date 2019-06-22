package com.nodes;

/*
 * This class represents a node containing next and previous reference to itself
 */
public class DoubleNode{
	private int data;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DoubleNode getNext() {
		return next;
	}
	public void setNext(DoubleNode next) {
		this.next = next;
	}
	public DoubleNode getPrev() {
		return prev;
	}
	public void setPrev(DoubleNode prev) {
		this.prev = prev;
	}
	private DoubleNode next;
	private DoubleNode prev;
	
	

}
