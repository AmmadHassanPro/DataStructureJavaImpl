package com.hashtables;

public class HashtableListTest {

	public static void main(String[] args) {
		
		HashtableNode node1 = new HashtableNode("one",1);
		
		HashtableList testLinkedList = new HashtableList(node1);
		
		HashtableNode node2 = new HashtableNode("two",2);
		HashtableNode node3 = new HashtableNode("three",3);
		HashtableNode node4 = new HashtableNode("four",4);
		HashtableNode node5 = new HashtableNode("five",5);
		
		testLinkedList.add(node2);
		testLinkedList.add(node3);
		testLinkedList.add(node4);
		testLinkedList.add(node5);
		
		System.out.println("Getting each node and displaying value on the screen");
		
		int size = testLinkedList.getSize();
		
		for(int i=0;i<size;i++) {
			HashtableNode currentNode = testLinkedList.getNode(i);
			System.out.println("Node"+i+" {"+"key ="+currentNode.getKey() +" Value="+currentNode.getValue()+"}");
			
		}
		
		
		System.out.println("Removing 5th Node by passing the integer");
		testLinkedList.remove(4);
		size = testLinkedList.getSize();
		for(int i=0;i<size;i++) {
			HashtableNode currentNode = testLinkedList.getNode(i);
			System.out.println("Node"+i+" {"+"key ="+currentNode.getKey() +" Value="+currentNode.getValue()+"}");
			
		}
		
		
		System.out.println("Removing 2nd Node by passing a new node with the same exact data");
		testLinkedList.remove(new HashtableNode("two",2)); // Sized
		size = testLinkedList.getSize();
		for(int i=0;i<size;i++) {
			HashtableNode currentNode = testLinkedList.getNode(i);
			System.out.println("Node"+i+" {"+"key ="+currentNode.getKey() +" Value="+currentNode.getValue()+"}");
			
		}
		
		System.out.println("Replacing 3rd Node by passing a new node with different Data");
		testLinkedList.replace(2, new HashtableNode("six",6));
		size = testLinkedList.getSize();
		for(int i=0;i<size;i++) {
			HashtableNode currentNode = testLinkedList.getNode(i);
			System.out.println("Node"+i+" {"+"key ="+currentNode.getKey() +" Value="+currentNode.getValue()+"}");
			
		}
		
		System.out.println("Replacing 3rd Node by passing a new node with different Data");
		testLinkedList.replace(new HashtableNode("six",6), new HashtableNode("seven",7));
		size = testLinkedList.getSize();
		for(int i=0;i<size;i++) {
			HashtableNode currentNode = testLinkedList.getNode(i);
			System.out.println("Node"+i+" {"+"key ="+currentNode.getKey() +" Value="+currentNode.getValue()+"}");
			
		}
	
		
		
		
		
		
		
		

	}

}
