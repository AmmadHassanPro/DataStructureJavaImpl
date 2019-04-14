package com.hashtables;

public class HashMap {
	
	private HashtableList[] bucketArray;
	private int hashArraySize;
	
	public int getHashArraySize() {
		
		return hashArraySize;
	}
	
	public HashMap(int arraySize) {
		this.hashArraySize = arraySize;
		bucketArray = new HashtableList[arraySize];
		
		for (int i=0;i<arraySize;i++) {
			bucketArray[i]= new HashtableList();
			
		}
		
	}
	
	public boolean put(String key, int value) {
		
		//caculating the hash
		int hashedIndex =  this.getHash(key);
		//Check if the node is already present
		HashtableNode result = bucketArray[hashedIndex].containsKey(key);
		// If node not present already, then add it to the list
		if(result==null) {
			bucketArray[hashedIndex].add(new HashtableNode(key,value));
			return true;
		}
		//if node is present , just update the value		
		result.setValue(value);
		return true;
	
		
	}
	
	
	public boolean put(HashtableNode nodeTobeAdded) {
		
		//caculating the hash
		String key = nodeTobeAdded.getKey();
		int value = nodeTobeAdded.getValue();
		int hashedIndex = this.getHash(key);
	
		
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
	
	
	
	
	
	
	
	
	
	
	
	

}
