package com.bayviewglen.daythree;
public class BinarySearchTree {
	BinaryNode root;
	
	 public void insert(int key){ //first step in inserting, calls private
		 						//recursive method with two inputs later
		BinaryNode node  = new BinaryNode(key);
		if(root==null){ //if no root, adds as first node
			root = node;
		}else{
			add(root,node);
		}
	}
	 
	private void add(BinaryNode parent, BinaryNode x){ //recursive function, takes in 
													 //parent/root and x is what added node	
		if(x.getElement().compareTo(parent.getElement())<=0){
			if(parent.getLeftChild() != null){
			add(parent.getLeftChild(), x);
			}else{
				parent.setLeftChild(x);
			}
		}else if(x.getElement().compareTo(parent.getElement())>=0){
			if(parent.getRightChild() != null){
			add(parent.getRightChild(), x);
			}else{
				parent.setRightChild(x);
			}
		}
	}
	
	public void delete(int key){
		
	}
	
	public BinaryNode find(int findThis){
		
		if(root != null){
			BinaryNode node = new BinaryNode(findThis);
			return find(root,node);
		}else
			return null;
	}
	
	private BinaryNode find(BinaryNode parent, BinaryNode x){
		
		if(parent != null){
			if(parent.getElement() == x.getElement()){
				return parent;
			}else{
				BinaryNode findInTree = find(parent.getLeftChild(), x);
				
				if(findInTree == null){
					findInTree = find(parent.getRightChild(), x);
				}
				return findInTree;
			}
		}
			return null;
	}
	
	public void preOrder(BinaryNode root){
		//ProcessNode(root.getElement());
		System.out.println(root.getElement());
		if(root.getLeftChild()!=null){
			preOrder(root.getLeftChild());
		}
		if(root.getRightChild() !=null){
			preOrder(root.getRightChild());
		}
	}
	public void inOrder(BinaryNode root){
		//ProcessNode(root.getElement());
		if(root.getLeftChild()!=null){
			inOrder(root.getLeftChild());
		}
		System.out.println(root.getElement());
		if(root.getRightChild() !=null){
			inOrder(root.getRightChild());
		}
	}
	public void postOrder(BinaryNode root){
		//ProcessNode(root.getElement());
		if(root.getLeftChild()!=null){
			postOrder(root.getLeftChild());
		}
		if(root.getRightChild() !=null){
			postOrder(root.getRightChild());
		}
		System.out.println(root.getElement());
	}
}