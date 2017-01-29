package com.bayviewglen.daythree;
public class BinaryNode {
	
	private BinaryNode leftChild; 
	private BinaryNode rightChild;
	private Comparable element;

	public BinaryNode(Comparable key){
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
	public Comparable getElement() {
		return element;
	}
	public void setElement(Comparable element) {
		this.element = element;
	}
}