package com.bayviewglen.dayfour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class AdressBook extends Contacts {

	static Scanner input = new Scanner(System.in);

	static Map<String, ArrayList<Contacts>> map  = new HashMap<String, ArrayList<Contacts>>();
	static ArrayList<Contacts> list = new ArrayList<Contacts>();

	// rest of the code

	public static void addContacts(Contacts addthis) {
		
		
		list.add(addthis);

	}

	public static void listAll() {

		for (Contacts x : list) {
			System.out.println(x.getFname() + " " + x.getLname() + " " + x.getPhone());
		}
	}

	public static void search() {

		String search = input.nextLine();
		boolean found = false;
		Contacts rememberWhichContacts = null;

		for(Entry<String, ArrayList<Contacts>> entry : map.entrySet() ){
			if (entry.getKey() != null && entry.getKey().contains(search) ){
				found = true;
				rememberWhichContacts = entry.getValue().get(0);
			} 
				else{
				System.out.println("Not found");
			}
		
		}
		if (found == true) {
			System.out.println("Your Contacts was found!");
			System.out.println("First Name:" + rememberWhichContacts.getFname());
			System.out.println("Last Name:" + rememberWhichContacts.getLname());
			System.out.println("Phone:" + rememberWhichContacts.getPhone());
		}

	}
}