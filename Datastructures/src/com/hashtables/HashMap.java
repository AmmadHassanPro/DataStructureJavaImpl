package com.hashtables;

import java.util.ArrayList;

public class HashMap {
	
	private HashtableList[] bucketArray;
	private int hashArraySize;
	private int size; // Number of actual elements present
	private float loadfactor=0.75f;
	private ArrayList<Integer> indexStoredList = new ArrayList<>(); // This will store the hashed index on which values are stored
	
	public HashMap() {
		this.size=0;
		int arraySize =16;
		this.hashArraySize = arraySize;
		bucketArray = new HashtableList[arraySize];
		
		for (int i=0;i<arraySize;i++) {
			bucketArray[i]= new HashtableList();
			
		}
		
		loadfactor=0.75f;
	}
	
	public HashMap(int arraySize) {
		this.size=0;
		this.hashArraySize = arraySize;
		bucketArray = new HashtableList[arraySize];
		
		for (int i=0;i<arraySize;i++) {
			bucketArray[i]= new HashtableList();
			
		}
		loadfactor=0.75f;
		
	}
	
	
	public HashMap(int arraySize ,float lf) {
		this.size=0;
		this.hashArraySize = arraySize;
		bucketArray = new HashtableList[arraySize];
		
		for (int i=0;i<arraySize;i++) {
			bucketArray[i]= new HashtableList();
			
		}
		loadfactor=lf;
		
	}
	
	private int getHashArraySize() {
		
		return hashArraySize;
	}
	
	
	public boolean put(String key, int value) {
		
		//caculating the hash
		int hashedIndex =  this.getHash(key);
		//Check if the node is already present
		HashtableNode result = bucketArray[hashedIndex].containsKey(key);
		// If node not present already, then add it to the list
		if(result==null) {
			bucketArray[hashedIndex].add(new HashtableNode(key,value));
			indexStoredList.add(hashedIndex);
			increaseSize();
			return true;
		}
		//if node is present , just update the value		
		result.setValue(value);
		increaseSize();
		return true;
	
		
	}
	
	
	public boolean put(HashtableNode nodeTobeAdded) {
		
		//caculating the hash
		String key = nodeTobeAdded.getKey();
		int value = nodeTobeAdded.getValue();
		int hashedIndex = this.getHash(key);
		//Check if the node is already present
				HashtableNode result = bucketArray[hashedIndex].containsKey(key);
				// If node not present already, then add it to the list
				if(result==null) {
					bucketArray[hashedIndex].add(new HashtableNode(key,value));
					indexStoredList.add(hashedIndex);
					increaseSize();
					return true;
				}
				//if node is present , just update the value		
				result.setValue(value);
				increaseSize();
				return true;
	
		
	}
	
	public HashtableNode get(String key) {
		int hashedIndex = this.getHash(key);
		HashtableList bucket = this.bucketArray[hashedIndex];
		return bucket.getNode(key);
		
	}
	
	public int getHash(String key) {
		
		int code =  key.hashCode() < 0 ? (key.hashCode()*(-1)) :key.hashCode() ; // making it unsigned
		
		return code % this.getHashArraySize();
	}
	
	public int getHash(String key,int size) {
		
		int code =  key.hashCode() < 0 ? (key.hashCode()*(-1)) :key.hashCode() ; // making it unsigned
		
		return code % size;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean remove(String key) {
		int hashedIndex = this.getHash(key);
		HashtableNode result = this.bucketArray[hashedIndex].containsKey(key);
		if(result == null) {
			return false;
			
		}
		//Otherwise
		this.bucketArray[hashedIndex].remove(result);
		// Since the remove method of ArrayList expects the object to be removed, 
		//if passed integer , it will take it as index and try to remove the value on that index,
		// that is why creater an interger object and passing it, which will be converted automatically when it will reach the method body
		//this was done just to call that overloaded method
		Integer removeIntObject = new Integer(hashedIndex);
		indexStoredList.remove(removeIntObject);
		
		reduceSize();
		return true;		
	}
	
	//This method will reduce size and adjust the load by downsizing the array
	private void reduceSize() {
		size--;
		
		float currentLoad = calculateLoadFactor();
		
		if (currentLoad < (this.loadfactor / 2) ) {
			
			this.resize(0.5f);
		}
		
		
	}
	
	private void increaseSize() {
		size++;
	
		float currentLoad = calculateLoadFactor();
		if (currentLoad > this.loadfactor) {
			
			// if its greater than resize , double it
			this.resize(2);
			
		}
		
	}
	
	private float calculateLoadFactor() {
		
		
		return ((float)this.size/this.hashArraySize);
		
	}
	
	//@param :float , factor by which it should increase or decrease
	private void resize(float factor) {
		int newArraySize = (int) (this.hashArraySize * factor);
		
		HashtableList[] newArray = new HashtableList[newArraySize];
		
		for (int i=0;i<newArraySize;i++) {
			newArray[i]= new HashtableList();
			
		}
		
		HashtableList[] oldArray = this.bucketArray;
		ArrayList<Integer> oldIndexStoredList = this.indexStoredList;
		// Since the index list can contain duplicate indexes we need to keep track of what indexes we have already checked
		ArrayList<Integer> alreadyCheckedIndex = new ArrayList<>();
		
		ArrayList<Integer> newIndexStoredList= new ArrayList<>(); 
		for(int i=0;i<oldIndexStoredList.size();i++) {
			int index = oldIndexStoredList.get(i);
			
			if(alreadyCheckedIndex.contains(index)) {
				continue;
			}
			
			
			
			
			HashtableList tempList= oldArray[index];
			int temListSize = tempList.getSize(); //as size will dynamically change when transferring , so keeping the size before hand
			for(int n=0;n<temListSize;n++) {
				
				HashtableNode tempNode = tempList.getNode(0);
				// Removing the node from the current Linked List , so that it cannot be reference from the old list
				tempList.remove(tempNode);
				//Setting it null, so that it accidently does not refer anything from the old Linked List
				tempNode.setNext(null);
				
				int newHashedIndex = this.getHash(tempNode.getKey(),newArraySize);
				newArray[newHashedIndex].add(tempNode);
				newIndexStoredList.add(newHashedIndex);
				
			}
			
			alreadyCheckedIndex.add(index);
			
			
			
		}
		
		this.bucketArray = newArray;
		this.indexStoredList = newIndexStoredList;
		this.hashArraySize = this.bucketArray.length;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
