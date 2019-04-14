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
	
	public HashtableList(){
			
			
		}
	
	public boolean add(HashtableNode node) {

		if(node==null)
			return false;
		if(headPointer==null) {
			headPointer =node;
			return true;
		}
		
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
	
	public boolean remove(int index) {
		
		HashtableNode currentRef=headPointer ;
		if(index==0) {
			headPointer = currentRef.getNext();
			return true;
		}
		
		if(index>=this.getSize()) {
			return false;
		}
		
		int count=0;
		//iterating to the required index
		while(currentRef.getNext()!=null) {
			currentRef = currentRef.getNext();
			count++;
			if(count== (index-1)) {
				break;
				
			}
		}
		
		HashtableNode nodetoDelete = currentRef.getNext();
		currentRef.setNext(nodetoDelete.getNext());
		return true;
		
	}
	
	public boolean remove(HashtableNode nodeToRemove) {

		HashtableNode currentRef = headPointer;
		boolean nodeFound = false;
		
		if(nodeToRemove == currentRef) {
			if(currentRef.getNext()!=null) {
				headPointer =currentRef.getNext();
				return true;
				
			}
			headPointer = null;
			return true;
		}
		
	
		//Iterating towards the node in the list
		try{
		while(!(currentRef.getNext().getKey().equals(nodeToRemove.getKey()))) {
			currentRef = currentRef.getNext();
		}
		
		
		HashtableNode nextRefFromRemovedNode = currentRef.getNext().getNext();
		//Setting Current Ref to skip the removed node
		currentRef.setNext(nextRefFromRemovedNode);
		nodeFound = true;
		}
		
		catch(NullPointerException ex) {
			return (nodeFound = false);
			
		}
		
		
		return nodeFound;
	}
	
	public boolean replace(HashtableNode currentNode , HashtableNode newNode) {
		
		HashtableNode currentRef = headPointer ;
		HashtableNode nextRefFromReplaceNode = null;
		
		if(currentNode.getKey().equals(currentRef.getKey())) {
			newNode.setNext(headPointer.getNext());
			headPointer=newNode;
			return true;
		}
		
		
		try {
		//Traversing to the next 
		while(!(currentRef.getNext().getKey().equals(currentNode.getKey()))) {
			currentRef= currentRef.getNext();
		}
		
		nextRefFromReplaceNode = currentRef.getNext().getNext();
		}
		catch(NullPointerException ex) {
			currentRef.setNext(newNode);
			newNode.setNext(null);
			return true;
			
		}
		finally {
			currentRef.setNext(newNode);
			newNode.setNext(nextRefFromReplaceNode);
			
			
		}
		
		
		return false;
		
		
		
	}
	
public boolean replace(int index , HashtableNode newNode) {
		
		if(index>=this.getSize()) {
			return false;
		}
		if(index==0) {
			newNode.setNext(headPointer.getNext());
			headPointer=newNode;
			return true;
		}		
		
		HashtableNode currentRef = headPointer ;
		HashtableNode nextRefFromReplaceNode = null;
		int count=0;
		
		try {
		//Traversing to the next 
		while(currentRef.getNext()!=null) {
			
			currentRef= currentRef.getNext();
			count++;
			if(count==(index-1)) {
				break;
			}
		}
		
		nextRefFromReplaceNode = currentRef.getNext().getNext();
		}
		catch(NullPointerException ex) {
			currentRef.setNext(newNode);
			newNode.setNext(null);
			return true;
			
		}
		finally{
			
			currentRef.setNext(newNode);
			newNode.setNext(nextRefFromReplaceNode);
		}
		
		return false;
		
		
		
	}


	// If it contains the key, it will return the object
	public HashtableNode containsKey(String key) {
		
		return this.getNode(key);
		
	}
	


	
	
		
	
}
