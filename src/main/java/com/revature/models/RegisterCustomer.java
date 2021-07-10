package com.revature.models;

//import java.util.Scanner;

//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterCustomer extends Character {
//	private static Scanner scan = new Scanner(System.in);
//	private static Logger log = LoggerFactory.getLogger(Character.class);

	private String userName;
	private String address;
	private boolean isLoggedIn = false;

	// Constructor with fields
	public RegisterCustomer(String firstName, String lastName, String password, String address, String confirmAns,
			String userName, boolean isLoggedIn) {
		super(firstName, lastName, password);
		this.address = address;
//		setRegistered(setConfirm(confirmAns));
		this.userName = userName;
		setConfirm(confirmAns);

	}

	// No args Constructor
	public RegisterCustomer() {
		super();
	}

	// Getters
	public String getUserName() {
		return userName;
	}

	public String getAddress() {
		return address;
	}

	public String getCustomer() {
		String details = "First name: " + this.getFirstName() + "\n" + "Last name: " + this.getLastName() + "\n"
				+ "Address: " + this.address + "\n" + "Password: " + this.getPassWord();
		return details;
	}

	// Setters
//	public void setRegistered(boolean setRegistered) {
//		this.isRegistered = setRegistered;
//	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public void setRegistered(boolean isRegistered) {
//		this.isRegistered = isRegistered;
//	}
//
	public void setConfirm(String setConfirm) {
		this.setRegistered(true);
//		return	setRegistered(setConfirm);
//		return setConfirm;

	}

	// toString
	@Override
	public String toString() {
		return "RegisteredCustomer [userName=" + userName + ", address=" + address + ", isRegistered=" + getRegistered()
				+ ", getLastName()=" + getLastName() + ", getFirstName()=" + getFirstName() + ", getLoggedIn()="
				+ getLoggedIn() + ", getPassWord()=" + getPassWord() + "]";
	}

	// HasCode & Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (getRegistered() ? 1231 : 1237);
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterCustomer other = (RegisterCustomer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (getRegistered() != other.getRegistered())
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

}
