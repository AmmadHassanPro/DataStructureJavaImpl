package com.nodes;

/*
 * This class represent a node on a Binary Tree
 */
public class TreeNode{
	
	private TreeNode leftchild;
	private TreeNode rightchild;
	private int value;
	private int childcount;
	
	public TreeNode(){
		leftchild =null;
		rightchild = null;
		value =0;
		childcount=0;
	}

	public TreeNode getLeftchild() {
		childcount++;
		return leftchild;
		
	}

	public void setLeftchild(TreeNode leftchild) {
		this.leftchild = leftchild;
	}

	public TreeNode getRightchild() {
		return rightchild;
	}

	public void setRightchild(TreeNode righchild) {
		childcount++;
		this.rightchild = righchild;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void removeLeft() {
		childcount--;
		this.leftchild = null;
	}
	public void removeRight() {
		childcount--;
		this.rightchild = null;
	}
	
	
	
	
	
	

}
