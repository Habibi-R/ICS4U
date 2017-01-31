package com.bayviewglen.daythree;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(100);
		tree.insert(5);
		tree.insert(13);
		tree.insert(15);
		tree.insert(4);
		tree.insert(3);
		tree.preOrder(tree.root);
	}
}