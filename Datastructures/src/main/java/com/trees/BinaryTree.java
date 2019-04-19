package com.trees;


import com.nodes.TreeNode;

public class BinaryTree {
	
	private TreeNode root;
	private int nodeCount;
	
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
	
	
	public boolean find(TreeNode node) {
		
		if(node.getValue() == (root!=null ? root.getValue(): null)) {
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
	
	public boolean remove(TreeNode node) {
		
		
		return removeRecursive(node, root,null);
		
		
	}
	
	
	public boolean removeRecursive(TreeNode node, TreeNode currentPointer, TreeNode previousPointer) {
		
		
		
		// check if the pointer has no left or right , then just delete
		int nodeVal = node.getValue();
		boolean hasLeft = currentPointer.getLeftchild()==null ? false : true;
		boolean hasRight = currentPointer.getRightchild()==null ? false : true;
		
		boolean isOnRight = previousPointer.getRightchild()== currentPointer ?true : false;
		boolean isOnLeft = previousPointer.getLeftchild() == currentPointer ? true : false;
		
		// Case 1: Where the node is a leaf node
		if(nodeVal == currentPointer.getValue()) {
			
		if ( !hasLeft && !hasRight) {
			if(previousPointer.getLeftchild()==currentPointer) {
				previousPointer.setLeftchild(null);
				return true;
			}
			if(previousPointer.getRightchild()==currentPointer) {
				previousPointer.setRightchild(null);
				return true;
			}
			
		}
		
		//Case2: Where the node has one child
		if(hasLeft && !hasRight) {
			if(previousPointer.getLeftchild()==currentPointer) {
				previousPointer.setLeftchild(currentPointer.getLeftchild());
				return true;
			}
			
			if(previousPointer.getRightchild()==currentPointer) {
				previousPointer.setRightchild(currentPointer.getLeftchild());
				return true;
			}
			
		}
		
		if(hasRight && !hasLeft) {
			if(previousPointer.getLeftchild()==currentPointer) {
				previousPointer.setLeftchild(currentPointer.getRightchild());
				return true;
			}
			
			if(previousPointer.getRightchild()==currentPointer) {
				previousPointer.setRightchild(currentPointer.getRightchild());
				return true;
			}
			
			
		}
		
		// Case3 : Where node has two children
		
		if(hasLeft && hasRight) {
			// Finding the minimum in right subtree
			TreeNode PrevReferenceToMinimumInRightSubtree = findMinRight(currentPointer.getRightchild(),currentPointer); // Will return reference to prev node of the minimum node
			TreeNode copiedNode = createCopy(PrevReferenceToMinimumInRightSubtree.getLeftchild().getValue());
			copiedNode.setRightchild(currentPointer.getRightchild());
			copiedNode.setLeftchild(currentPointer.getRightchild());
			
			//Replacing the removed node with the duplicate of minVal
			if(isOnRight) {
				previousPointer.setRightchild(copiedNode);
			}
			if(isOnLeft) {
				previousPointer.setLeftchild(copiedNode);
			}
			
			// Checking if that lowest element has any right subtree, if so recursively remove that and re arrange
			if(PrevReferenceToMinimumInRightSubtree.getLeftchild().getRightchild() !=null) {
				removeRecursive(copiedNode, PrevReferenceToMinimumInRightSubtree.getLeftchild().getRightchild(), PrevReferenceToMinimumInRightSubtree.getLeftchild());
			}
			
			
			return true;
		}
		
		}
		
		if(nodeVal > currentPointer.getValue()) {
			return removeRecursive(node, currentPointer.getRightchild(),currentPointer);
		}
		if(nodeVal<currentPointer.getValue()) {
			return removeRecursive(node,currentPointer.getLeftchild(),currentPointer);
		}
		
		//if everything fails
		return false;
		
		
		
		
	}
	
	private TreeNode findMinRight(TreeNode pointer,TreeNode prev) {
		if (pointer.getLeftchild()!=null) {
			findMinRight(pointer.getLeftchild(),pointer);
		}
		
		return prev;	
	}
	
	private TreeNode createCopy(int val) {
		
		TreeNode newNode= new TreeNode();
		newNode.setValue(val);
		return newNode;
		
	}
	
	
	
	


}
