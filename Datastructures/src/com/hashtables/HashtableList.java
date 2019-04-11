package com.hashtables;
// This class is the individual list that buckets will refer to , store objects in this list when a collision occurs

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
		// Traversing to the last element
		if(node==null)
			return false;
		
		HashtableNode currentRef=headPointer ;
		
		while(currentRef!=null) {
			currentRef = currentRef.getNext();
		}
		
		currentRef.setNext(node);
		
		
		
		return true;
		
		
	}
	
	
	public int getSize() {
		HashtableNode currentRef=headPointer ;
		
		while(currentRef!=null) {
			currentRef = currentRef.getNext();
		}
		return 0;
		
	}	
	
	
	
	
	
	
	
	
	
	

}
