package com.bayviewglen.contact;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;

public class BinarySearchTree {
	public static BinaryNode root;
	static Formatter xyz;
	
	 public void insert(Contact key){ //first step in inserting, calls private
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
	
	public void remove(Comparable el, BinaryNode node, BinaryNode parent) {
        if (node == null || node.getElement() == null) {
                        System.out.println("The element does not exist.");
                        return;
        }

        if (node.getElement().compareTo(el) == 0) {

                        if (node.equals(parent)) {
                                        removeSpecialCase(el, node);
                        } else if (node.getLeftChild() == null && node.getRightChild() == null) {
                                        if (parent.getRightChild().getElement().equals(node.getElement())) {
                                                        parent.setRightChild(null);
                                        } else {
                                                        parent.setLeftChild(null);
                                        }

                        } else if (node.getLeftChild() == null) {
                                        if (parent.getLeftChild().getElement().equals(node.getElement())) {
                                                        parent.setLeftChild(node.getRightChild());
                                        } else {
                                                        parent.setRightChild(node.getRightChild());
                                        }
                        } else if (node.getRightChild() == null) {
                                        if (parent.getLeftChild().getElement().equals(node.getElement())) {
                                                        parent.setLeftChild(node.getLeftChild());
                                        } else {
                                                        parent.setRightChild(node.getLeftChild());
                                        }
                        } else {
                                        BinaryNode temp = minValue(node.getRightChild());
                                        remove(temp.getElement(), node, node);
                                        node.setElement(temp.getElement());
                        }
        } else {
                        if (el.compareTo(node.getElement()) <= 0) {
                                        remove(el, node.getLeftChild(), node);
                        } else {
                                        remove(el, node.getRightChild(), node);
                        }
        }

}
    BinaryNode minValue(BinaryNode node) {
        BinaryNode current = node;
 
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return (current);
    }

	
private void removeSpecialCase(Comparable el, BinaryNode node) {
        if (node.getLeftChild() == null && node.getRightChild() == null) {
                        root = null;
        } else if (node.getLeftChild() == null) {
                        node = node.getRightChild();
        } else if (node.getRightChild() == null) {
                        node = node.getLeftChild();
        } else {
                        BinaryNode temp = node.getLeftChild();
                        node = node.getRightChild();
                        node.setLeftChild(temp);

        }
}

	
	public BinaryNode find(Contact findThis){
		
		if(root != null){
			BinaryNode node = new BinaryNode(findThis);
			return find(root,node);
		}else
			return null;
	}
	
	private BinaryNode find(BinaryNode parent, BinaryNode x){
		
		if(parent != null){
			if(((Contact) parent.getElement()).getLname().equals(((Contact) x.getElement()).getLname()) ){
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
	public void DisplayAll(BinaryNode root){
		//ProcessNode(root.getElement());
		if(root.getLeftChild()!=null){
			DisplayAll(root.getLeftChild());
		}
		System.out.println(((Contact) root.getElement()).getFname() + " " + ((Contact) root.getElement()).getLname() + " " + ((Contact) root.getElement()).getPhone());
		if(root.getRightChild() !=null){
			DisplayAll(root.getRightChild());
		}
	}
	
	public void WriteIt(BinaryNode root) throws FileNotFoundException{
		//ProcessNode(root.getElement());
		try {
			xyz =  new Formatter("AddressBookSave.txt");
		} catch (Exception e) {
			System.out.println("Error in opening file!!");
		}
		PrintWriter writer = new PrintWriter("AddressBookSave.txt");
		writer.print("");
		writer.close();
		if(root.getLeftChild()!=null){
			WriteIt(root.getLeftChild());
		}
		System.out.println(root.getElement());
		String output = ((Contact) root.getElement()).getFname() + " " + ((Contact) root.getElement()).getLname() + " " + ((Contact) root.getElement()).getPhone();
		xyz.format("%s", output);
		
		if(root.getRightChild() !=null){
			WriteIt(root.getRightChild());
		}
		xyz.close();
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