package com.bayviewglen.daytwo;

import java.util.ArrayList;
import java.util.Scanner;

public class AdressBook extends Contact {

	static Scanner input = new Scanner(System.in);

	static ArrayList<Contact> list = new ArrayList<Contact>();

	// rest of the code

	public static void addContact(Contact ContactNew) {
		list.add(ContactNew);

	}

	public static void listAll() {

		for (Contact x : list) {
			System.out.println(x.getFname() + " " + x.getLname() + " " + x.getPhone());
		}
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