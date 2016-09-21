package com.bayviewglen.dayfour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bayviewglen.daytwo.Contact;

public class AdressBook extends Contact {

	static Scanner input = new Scanner(System.in);

	static Map<String, ArrayList<Contact>> map  = new HashMap<String, ArrayList<Contact>>();
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

		
			if (map.containsKey(search)){
				found = true;
				rememberWhichContact = ;
			} else if(map.containsValue(search)){
				found =true;
				rememberWhichContact = 
			}
				else{
				System.out.println("Not found");
			}
		
		
		if (found == true) {
			System.out.println("Your contact was found!");
			System.out.println("First Name:" + rememberWhichContact.getFname());
			System.out.println("Last Name:" + rememberWhichContact.getLname());
			System.out.println("Phone:" + rememberWhichContact.getPhone());
		}

	}
}