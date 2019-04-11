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
		int count = 0;
		HashtableNode currentRef=headPointer ;
		
		while(currentRef!=null) {
			currentRef = currentRef.getNext();
			count++;
		}
		return count;
		
	}	
	
	public HashtableNode getNodeFromIndex(int index) {
		
		int count = 0;
		HashtableNode currentRef=headPointer ;
		
		while(currentRef!=null) {
			currentRef = currentRef.getNext();
			count++;
			if(count == index)
			return 	currentRef;
		
		}
		return null;
	}
	
	
	public HashtableNode getNodeFromKey(String key) {
		
		
	HashtableNode currentRef=headPointer ;
	
		if(currentRef.getKey().equals(key)) {
			return currentRef;
		}
		
		while(currentRef!=null) {
			currentRef = currentRef.getNext();
			if(currentRef.getKey().equals(key)) {
				return currentRef;
			}
		
		}
		
		return null;
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
