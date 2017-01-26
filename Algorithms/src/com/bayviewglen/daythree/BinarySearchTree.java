package com.bayviewglen.daythree;

public class BinarySearchTree {

	private BinaryNode root;
	
	public void insert(BinaryNode node){ //inserts a node
		
		if(root==null){ //if no root, adds as first node
			root = node;
		}else{ //if existing root
			BinaryNode current = root; //saves root before recursive calls
			if(root.getElement()>node.getElement()){ //checks key sizes to decide which side node goes of the root
				root=root.getLeftChild();
				insert(node); //recursive call 
			}else if(root.getElement()<node.getElement()){ //checks key sizes to decide which side node goes of the root
				root=root.getRightChild();
				insert(node); //recursive call
			}
			root=current; //restores original root after recursion 
		}
	}
	//might not work
	public void preOrder(BinaryNode root){
		//ProcessNode(root.getElement());
		if(root!= null){
			System.out.println(root.getElement());
		}
		preOrder(root.getLeftChild());
		preOrder(root.getRightChild());
	}
	
	
}
