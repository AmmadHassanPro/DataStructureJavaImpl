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
		indexStoredList.remove(hashedIndex);
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
		
		int difference = this.hashArraySize - this.size;
		return (difference/this.hashArraySize);
		
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
		ArrayList<Integer> newIndexStoredList= new ArrayList<>(); 
		for(int i=0;i<oldIndexStoredList.size();i++) {
			
			
			HashtableList tempList= oldArray[oldIndexStoredList.get(i)];
			
			for(int n=0;n<tempList.getSize();n++) {
				
				HashtableNode tempNode = tempList.getNode(n);
				int newHashedIndex = this.getHash(tempNode.getKey(),newArraySize);
				newArray[newHashedIndex].add(tempNode);
				newIndexStoredList.add(newHashedIndex);
				
			}
			
			this.bucketArray = newArray;
			this.indexStoredList = newIndexStoredList;
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
