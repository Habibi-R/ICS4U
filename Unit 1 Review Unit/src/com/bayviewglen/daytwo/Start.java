package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Start extends AdressBook {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		// TODO Auto-generated method stub

		boolean done = false;

		System.out.println("Welcome to your address book! Be sure to fill it up with your friends and family!");

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
				System.out.println("Who do you want to search? Enter either first name, last name, or phone number");
				search();

			} else if (selection.length() > 0 && selection.charAt(0) == '4') {
				done = true;
			} else {
				System.out.println("Command not recognized");
			}

		}

	}

}