package com.hashtables;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		HashMap testHashMap = new HashMap(1000);
		
		
		testHashMap.put("one",1);
		testHashMap.put("two",2);
		testHashMap.put("three",3);
		HashtableNode node4 = new HashtableNode("four",4);
		HashtableNode node5 = new HashtableNode("five",5);
		testHashMap.put(node4);
		testHashMap.put(node5);
		
		
		
		System.out.println("Getting Node 3");
		HashtableNode result = testHashMap.get("three");
		System.out.println("Node Key:"+result.getKey()+" Value:"+result.getValue());
		
		
		
		
		
	}

}
