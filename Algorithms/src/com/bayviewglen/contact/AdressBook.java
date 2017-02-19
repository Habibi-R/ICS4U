package com.bayviewglen.contact;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;


public class AdressBook {

	static Scanner input = new Scanner(System.in);

	 //static ArrayList<Contact> list = new ArrayList<Contact>();
	
	static BinarySearchTree tree = new BinarySearchTree();
	
	
	// rest of the code

	public static void addContact(Contact ContactNew) {
		tree.insert(ContactNew);

	}

	public static void listAll() {
		
		if(tree.root!=null){
			tree.DisplayAll(tree.root);
		}else{
			System.out.println("Phonebook is empty");
		}
		
	}

	public static void search() {
		
		Contact searchContact = new Contact();
		String search = input.nextLine();
		searchContact.setLname(search);
		Contact rememberWhichContact = null;
		try {
			rememberWhichContact = (Contact) tree.find(searchContact).getElement();
		} catch (Exception e) {
			System.out.println("Not Found");
		}
		
		if (rememberWhichContact != null) {
			System.out.println("Your contact was found!");
			System.out.println("First Name: " + rememberWhichContact.getFname());
			System.out.println("Last Name: " + rememberWhichContact.getLname());
			System.out.println("Phone: " + rememberWhichContact.getPhone());
		}

	}
}