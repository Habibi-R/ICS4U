package com.bayviewglen.contact;

import java.io.*;
import java.util.*;


public class Start extends AdressBook {
	static Formatter xyz;
	static Scanner abc;

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		// TODO Auto-generated method stub

		boolean done = false;

		System.out.println("Welcome to your address book! Be sure to fill it up with your friends and family!");
		findFileForRead();
		readFile();
		while (!done) {
			
			System.out.println("\nTo add a contact, enter 1. \nTo display all contacts enter 2."
					+ " \nTo search for a specific contact and display it enter 3.\nTo exit, enter 4.");

			String selection = input.nextLine();
			if (selection.length() > 0 && selection.charAt(0) == '1') {

				Contact newContact = new Contact();
				System.out.println("What is their first name?");
				String name = input.nextLine();
				newContact.setFname(name);

				System.out.println("What is their last name?");
				String last = input.nextLine();
				newContact.setLname(last);

				System.out.println("What is their number?");
				String num = input.nextLine();
				newContact.setPhone(num);

				addContact(newContact);

				System.out.println("Contact added!");

			} else if (selection.length() > 0 && selection.charAt(0) == '2') {

				listAll();
				System.out.println();

			} else if (selection.length() > 0 && selection.charAt(0) == '3') {
				System.out.println("Who do you want to search? Enter their last name to look up in phonebook!");
				search();

			} else if (selection.length() > 0 && selection.charAt(0) == '4') {
				done = true;
				openFile();
				writeToFile();

			} else {
				System.out.println("Command not recognized");
			}

		}

	}

	public static void openFile() {
		try {
			xyz =  new Formatter("AddressBookSave.txt");
		} catch (Exception e) {
			System.out.println("Error in opening file!!");
		}
	}

	/*public static void writeToFile() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter("AddressBookSave.txt");
		writer.print("");
		writer.close();
		for (Contact x : list) {
			String output = x.getFname() + " " + x.getLname() + " " + x.getPhone();
			xyz.format("%s", output);
		}
		xyz.close();
	}*/
	
	public static void writeToFile() throws FileNotFoundException{
		tree.WriteIt(tree.root);
		tree.xyz.close();
	}
	public static void findFileForRead(){
	
		try {
			abc =  new Scanner(new File("AddressBookSave.txt"));
		} catch (Exception e) {
			System.out.println("Error in opening file!!");
		}
	}
	
	public static void readFile(){
		while(abc.hasNext()){
			String first = abc.next();
			String last = abc.next();
			String num = abc.next();
			
			Contact newContact = new Contact();
			newContact.setFname(first);
			newContact.setLname(last);
			newContact.setPhone(num);
			addContact(newContact);
		}
	}
	

}