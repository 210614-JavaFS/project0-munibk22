package com.revature.models;

import java.util.Date;

//import java.util.Scanner;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class Customer extends Character {
//	private static Scanner scan = new Scanner(System.in);
//	private static Logger log = LoggerFactory.getLogger(Character.class);

	private String userName;
	private String address;
//	public boolean isLoggedIn = false;
	private String confirmAns;
	private Account account;
	private String sSecurity;
	private boolean reg = true;

	private int id;

	// Constructor with fields
	public Customer(String firstName, String lastName, String userName, String password, int checkingBalance,
			String address, String sSecurity, boolean isRegistered, boolean isActive) {
		super(firstName, lastName, sSecurity, checkingBalance, isRegistered, isActive);
		this.address = address;
//		setRegistered(setConfirm(confirmAns));
		this.userName = userName;
		setConfirm(confirmAns);
		this.sSecurity = sSecurity;

	}

	// No args Constructor
	public Customer() {
		super();
	}

	// Getters

	public Account getAccount() {
		return account;
	}

	public String getsSecurity() {
		return sSecurity;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setsSecurity(String sSecurity) {
		this.sSecurity = sSecurity;
	}

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

	public void setReg(boolean setRegistered) {
		this.reg = setRegistered;
	}

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
		return "RegisteredCustomer [userName=" + userName + ", isRegistered=" + getRegistered() + ", LastName ="
				+ getLastName() + ", FirstName=" + getFirstName() + ", IsActive=" + getIsActive() + ", PassWord="
				+ getPassWord() + "]";
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
		Customer other = (Customer) obj;
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

//	public boolean isLoggedIn() {
//		return isLoggedIn;
//	}
//
//	public void setLoggedIn(boolean isLoggedIn) {
//		this.isLoggedIn = isLoggedIn;
//	}

	/**
	 * @return the confirmAns
	 */
	public String getConfirmAns() {
		return confirmAns;
	}

	/**
	 * @param confirmAns the confirmAns to set
	 */
	public void setConfirmAns(String confirmAns) {
		this.confirmAns = confirmAns;
	}

	public boolean getReg() {
		// TODO Auto-generated method stub
		return this.reg;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param i the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
