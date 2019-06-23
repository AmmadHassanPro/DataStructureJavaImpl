package com.hashtables;

import java.util.ArrayList;

import com.lists.LinkedList;
import com.nodes.Node;

public class HashMap {
	
	private LinkedList[] bucketArray;
	private int hashArraySize;
	private int size; // Number of actual elements present
	private float loadfactor=0.75f;
	private ArrayList<Integer> indexStoredList = new ArrayList<>(); // This will store the hashed index on which values are stored
	
	public HashMap() {
		this.size=0;
		int arraySize =16;
		this.hashArraySize = arraySize;
		bucketArray = new LinkedList[arraySize];
		
		for (int i=0;i<arraySize;i++) {
			bucketArray[i]= new LinkedList();
			
		}
		
		loadfactor=0.75f;
	}
	
	public HashMap(int arraySize) {
		this.size=0;
		this.hashArraySize = arraySize;
		bucketArray = new LinkedList[arraySize];
		
		for (int i=0;i<arraySize;i++) {
			bucketArray[i]= new LinkedList();
			
		}
		loadfactor=0.75f;
		
	}
	
	
	public HashMap(int arraySize ,float lf) {
		this.size=0;
		this.hashArraySize = arraySize;
		bucketArray = new LinkedList[arraySize];
		
		for (int i=0;i<arraySize;i++) {
			bucketArray[i]= new LinkedList();
			
		}
		loadfactor=lf;
		
	}
	
	private int getHashArraySize() {
		
		return hashArraySize;
	}
	
	
	public int put(String key, int value) {
		
		//Calculating the hash
		int hashedIndex =  this.getHash(key);
		//Check if the node is already present
		Node result = bucketArray[hashedIndex].containsKey(key);
		// If node not present already, then add it to the list
		if(result==null) {
			Node newNode = new Node(key,value);
			bucketArray[hashedIndex].add(newNode);
			indexStoredList.add(hashedIndex);
			increaseSize();
			return newNode.getValue();
			
		}
		//if node is present ,then return the value		
		return result.getValue();
	}
	
	
	public Node put(Node nodeTobeAdded) {
		
		//Calculating the hash
		String key = nodeTobeAdded.getKey();
		int value = nodeTobeAdded.getValue();
		int hashedIndex = this.getHash(key);
		//Check if the node is already present
				Node result = bucketArray[hashedIndex].containsKey(key);
				// If node not present already, then add it to the list
				if(result==null) {
					bucketArray[hashedIndex].add(nodeTobeAdded);
					indexStoredList.add(hashedIndex);
					increaseSize();
					return null;
					
				}
				//if node is present , then return the value
				return result;
				
	}
	
	public Node get(String key) {
		int hashedIndex = this.getHash(key);
		LinkedList bucket = this.bucketArray[hashedIndex];
		return bucket.getNode(key);
		
	}
	
	private int getHash(String key) {
		int code =  key.hashCode() < 0 ? (key.hashCode()*(-1)) :key.hashCode() ; // making it unsigned
		return code % this.getHashArraySize();
	}
	
	private int getHash(String key,int size) {
		int code =  key.hashCode() < 0 ? (key.hashCode()*(-1)) :key.hashCode() ; // making it unsigned
		return code % size;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean remove(String key) {
		int hashedIndex = this.getHash(key);
		Node result = this.bucketArray[hashedIndex].containsKey(key);
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
	
	public Node remove(Node removeNode) {
		int hashedIndex = this.getHash(removeNode.getKey());
		Node result = this.bucketArray[hashedIndex].containsKey(removeNode.getKey());
		// If the node is not found at the index, return null
		if(result == null) {
			return null;
		}
		//If the node is found then remove it from the list
		this.bucketArray[hashedIndex].remove(result);
		reduceSize();
		return result;
		
		
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
		
		LinkedList[] newArray = new LinkedList[newArraySize];
		
		for (int i=0;i<newArraySize;i++) {
			newArray[i]= new LinkedList();
			
		}
		
		LinkedList[] oldArray = this.bucketArray;
		ArrayList<Integer> oldIndexStoredList = this.indexStoredList;
		// Since the index list can contain duplicate indexes we need to keep track of what indexes we have already checked
		ArrayList<Integer> alreadyCheckedIndex = new ArrayList<>();
		
		ArrayList<Integer> newIndexStoredList= new ArrayList<>(); 
		for(int i=0;i<oldIndexStoredList.size();i++) {
			int index = oldIndexStoredList.get(i);
			
			if(alreadyCheckedIndex.contains(index)) {
				continue;
			}
			
			LinkedList tempList= oldArray[index];
			int temListSize = tempList.getSize(); //as size will dynamically change when transferring , so keeping the size before hand
			for(int n=0;n<temListSize;n++) {
				
				Node tempNode = tempList.getNode(0);
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
