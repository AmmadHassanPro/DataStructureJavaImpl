package com.Sets;

import com.nodes.Node;

import com.hashtables.HashMap;

/*
 * This class is an implementation of HashSet in Java Collection.  However, for demo purposes it can Only store 
 * Node reference types belonging to com.nodes package
 */
public class HashSet {
	
	private HashMap map = new HashMap();// For Persistence
	
	public boolean add(Node addNode) {
		
		// Generating the key of the node, by taking its value
		addNode.setKey(this.generateKey(addNode));
		return (map.put(addNode) == null); // Element was not present, then new element will be added. If element was already present, it will not create duplicates
		
	}
	
	public boolean remove(Node removeNode) {
		removeNode.setKey(this.generateKey(removeNode));
		return (map.remove(removeNode) == removeNode);
		
	}
	
	
	// Generate the key based on the node value
	public String generateKey(Node node) {
		return Integer.toString(node.getValue());
	}
	
	public int getCount() {
		return map.size();
	}
	

}
