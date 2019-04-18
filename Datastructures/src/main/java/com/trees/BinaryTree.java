package com.trees;


import com.nodes.TreeNode;

public class BinaryTree {
	
	private TreeNode root;
	private int nodeCount;
	private TreeNode pointer;
	
	BinaryTree(){
		root=null;
		nodeCount=0;
		
	}
	
	public int getNodeCount() {
		return nodeCount;
	}
	
	public boolean add(TreeNode node) {
		if(root==null) {
			root=node;
			nodeCount++;
		}
		
		addRecursive(node,root);
		
		return true;
	}
	
	public boolean remove(TreeNode node) {
		
		return true;
	}
	
	public boolean find(TreeNode node) {
		
		if(node == root) {
			return true;
		}
		
		return findRecursive(node,root);
	}
	
	public boolean findRecursive(TreeNode node , TreeNode currentPointer) {
		int nodeVal = node.getValue();
		int currentPointerVal = currentPointer.getValue();
		
		if(nodeVal == currentPointerVal) {
			return true;
		}
		
		if(nodeVal > currentPointerVal) {
			if(currentPointer.getRightchild()!=null) {
				return findRecursive(node, currentPointer.getRightchild());
			}
			
		}
		
		if(nodeVal < currentPointerVal) {
			if(currentPointer.getLeftchild()!=null) {
				return findRecursive(node,currentPointer.getLeftchild());
			}
		}
		
		return false;

	}
	
	public boolean update(TreeNode node) {
		
		return true;
	}
	
	public void addRecursive(TreeNode addThisNode, TreeNode currentPointer) {
	
		// Finding the next traverse path , either left or right
		int currentPointerValue = currentPointer.getValue();
		int newNodeValue = addThisNode.getValue();
		if(newNodeValue> currentPointerValue) {
			if(currentPointer.getRightchild()==null) {
				currentPointer.setRightchild(addThisNode);
				nodeCount++;
			}
			else {
				addRecursive(addThisNode, currentPointer.getRightchild());
			}
		}
		
		if(newNodeValue<currentPointerValue) {
			if(currentPointer.getLeftchild()==null) {
				currentPointer.setLeftchild(addThisNode);
				nodeCount++;
			}
			else {
				addRecursive(addThisNode, currentPointer.getLeftchild());
			}
		}
	
	}
	
	
	
	
	


}
