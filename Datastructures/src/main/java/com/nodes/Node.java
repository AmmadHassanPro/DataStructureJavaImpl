package com.nodes;

// This will contain the key and value associated with it and a reference to the next element if any
public class Node {
	
	private String key;
	private int value; // assuming value will be in integer
	private Node next;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node(String k, int v){
		this.next=null;
		key = k;
		value =v;
		
	}
	
	
}
