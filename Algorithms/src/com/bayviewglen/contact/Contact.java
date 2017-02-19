package com.bayviewglen.contact;

public class Contact implements Comparable{

	private String lname;
	private String fname;
	private String phone;

	// complete the class by adding appropriate constructors, get, set methods,
	// etc.
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public int CompareTo(Contact anotherContact) {
		// TODO Auto-generated method stub
		
		return anotherContact.getPhone().compareTo(phone);
	}

	@Override
	public int compareTo(Comparable element) {
		// TODO Auto-generated method stub
		return 0;
	}
}