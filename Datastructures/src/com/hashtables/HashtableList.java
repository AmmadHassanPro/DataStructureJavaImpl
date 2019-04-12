package com.hashtables;
// This class is the individual list that buckets will refer to , store objects in this list when a collision occurs
// This code can also be used for implementation of Linked List

public class HashtableList {
	
	private HashtableNode headPointer;

	public HashtableNode getHeadPointer() {
		return headPointer;
	}

	public void setHeadPointer(HashtableNode headPointer) {
		this.headPointer = headPointer;
	}
	
	// Must pass an element in this list to initialize
	public HashtableList(HashtableNode head){
		
		headPointer = head;
	}
	
	
	public boolean add(HashtableNode node) {

		if(node==null)
			return false;
		
		HashtableNode currentRef=headPointer ;
		// Traversing to the last element		
		while(currentRef.getNext()!=null) {
		
			currentRef = currentRef.getNext();
		}
		
		currentRef.setNext(node);
		
		
		
		return true;
		
		
	}
	
	
	public int getSize() {
		int count = 1;
		HashtableNode currentRef=headPointer ;
		
		if(currentRef==null)
			return 0;
		
		while(currentRef.getNext()!=null) {
			currentRef = currentRef.getNext();
			count++;
		}
		return count;
		
	}	
	
	public HashtableNode getNode(int index) {
		
		int count = 0;
		HashtableNode currentRef=headPointer ;
		
		if(index==0) {
			return currentRef;
		}
		
		
		while(currentRef.getNext()!=null) {
			
			currentRef = currentRef.getNext();
			count++;
			if(count == index) {
			return 	currentRef;
			}
			
			
		
		}
		return null;
	}
	
	
	public HashtableNode getNode(String key) {
		
		
	HashtableNode currentRef=headPointer ;
	
		if(currentRef.getKey().equals(key)) {
			return currentRef;
		}
		
		while(currentRef.getNext()!=null) {
			currentRef = currentRef.getNext();
			if(currentRef.getKey().equals(key)) {
				return currentRef;
			}
		
		}
		
		return null;
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
