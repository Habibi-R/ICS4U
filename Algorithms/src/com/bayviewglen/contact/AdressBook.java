package com.bayviewglen.contact;

import java.util.ArrayList;
import java.util.Scanner;

import com.bayviewglen.daythree.BinarySearchTree;

public class AdressBook extends Contact {

	static Scanner input = new Scanner(System.in);

	static //static ArrayList<Contact> list = new ArrayList<Contact>();

	BinarySearchTree tree = new BinarySearchTree();
	
	
	// rest of the code

	public static void addContact(Contact ContactNew) {
		tree.insert((java.lang.Comparable) ContactNew);

	}

	public static void listAll() {

		tree.inOrder(tree.root);
	}

	public static void search() {

		String search = input.nextLine();
		boolean found = false;
		Contact rememberWhichContact = null;

		for (Contact x : list) {
			if (x.getFname().equalsIgnoreCase(search)) {
				found = true;
				rememberWhichContact = x;
			} else if (x.getLname().equalsIgnoreCase(search)) {
				found = true;
				rememberWhichContact = x;
			} else if (x.getPhone().equalsIgnoreCase(search)) {
				found = true;
				rememberWhichContact = x;
			} else {
				System.out.println("Not found");
			}

		}
		if (found == true) {
			System.out.println("Your contact was found!");
			System.out.println("First Name:" + rememberWhichContact.getFname());
			System.out.println("Last Name:" + rememberWhichContact.getLname());
			System.out.println("Phone:" + rememberWhichContact.getPhone());
		}

	}
}