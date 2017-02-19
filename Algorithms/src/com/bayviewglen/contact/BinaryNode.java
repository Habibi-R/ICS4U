package com.bayviewglen.contact;
public class BinaryNode {
	
	private BinaryNode leftChild; 
	private BinaryNode rightChild;
	private Contact element;

	public BinaryNode(Contact key){
		this.setElement(key);
		leftChild = null;
		rightChild = null;
	}
	
	public BinaryNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryNode leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryNode rightChild) {
		this.rightChild = rightChild;
	}
	public Contact getElement() {
		return element;
	}
	public void setElement(Contact element) {
		this.element = element;
	}
}