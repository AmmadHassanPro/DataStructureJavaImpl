package com.hashtables;

public class HashMap {
	
	private HashtableList[] bucketArray;
	private int hashArraySize;
	private int size; // Number of actual elements present
	private float loadfactor=0.75f;
	
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
	
	private int getHashArraySize() {
		
		return hashArraySize;
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
	
	public boolean put(String key, int value) {
		
		//caculating the hash
		int hashedIndex =  this.getHash(key);
		//Check if the node is already present
		HashtableNode result = bucketArray[hashedIndex].containsKey(key);
		// If node not present already, then add it to the list
		if(result==null) {
			bucketArray[hashedIndex].add(new HashtableNode(key,value));
			size++;
			return true;
		}
		//if node is present , just update the value		
		result.setValue(value);
		size++;
		return true;
	
		
	}
	
	
	public boolean put(HashtableNode nodeTobeAdded) {
		
		//caculating the hash
		String key = nodeTobeAdded.getKey();
		int value = nodeTobeAdded.getValue();
		int hashedIndex = this.getHash(key);
		size++;
		
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
	
	public int size() {
		return this.size;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
