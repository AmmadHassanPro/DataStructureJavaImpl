package com.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nodes.TreeNode;

public class BinaryTreeTests {
	private BinaryTree objectUnderTest= new BinaryTree();
	
	@Test
	public void add() {
		TreeNode n1 = new TreeNode();
		n1.setValue(10);
		
		TreeNode n2 = new TreeNode();
		n2.setValue(8);

		TreeNode n3 = new TreeNode();
		n3.setValue(7);
		
		TreeNode n4 = new TreeNode();
		n4.setValue(9);
		
		TreeNode n5 = new TreeNode();
		n5.setValue(12);
		
		TreeNode n6 = new TreeNode();
		n6.setValue(11);
		
		TreeNode n7 = new TreeNode();
		n7.setValue(13);
		
		objectUnderTest.add(n1);
		objectUnderTest.add(n2);
		objectUnderTest.add(n3);
		objectUnderTest.add(n4);
		objectUnderTest.add(n5);
		objectUnderTest.add(n6);
		objectUnderTest.add(n7);
		
		
		assertTrue(n1.getLeftchild() == n2 && n1.getRightchild() == n5);
		assertTrue(n2.getLeftchild() == n3 && n2.getRightchild() == n4);
		assertTrue(n5.getLeftchild() == n6 && n5.getRightchild() == n7);
	}
	

	@Test
	public void getNodeCount() {
		objectUnderTest.add(new TreeNode());
		assertEquals(1,objectUnderTest.getNodeCount());
	}
	
	@Test
	public void find() {
		TreeNode n1 = new TreeNode();
		n1.setValue(10);
		
		TreeNode n2 = new TreeNode();
		n2.setValue(8);

		TreeNode n3 = new TreeNode();
		n3.setValue(7);
		
		TreeNode n4 = new TreeNode();
		n4.setValue(9);
		
		TreeNode n5 = new TreeNode();
		n5.setValue(12);
		
		TreeNode n6 = new TreeNode();
		n6.setValue(11);
		
		TreeNode n7 = new TreeNode();
		n7.setValue(13);
		
		objectUnderTest.add(n1);
		objectUnderTest.add(n2);
		objectUnderTest.add(n3);
		objectUnderTest.add(n4);
		objectUnderTest.add(n5);
		objectUnderTest.add(n6);
		objectUnderTest.add(n7);
		assertTrue(objectUnderTest.find(n3));
		TreeNode shouldNotbeinTree = new TreeNode();
		n7.setValue(100);
		assertFalse(objectUnderTest.find(shouldNotbeinTree));
		
	}
	

}
