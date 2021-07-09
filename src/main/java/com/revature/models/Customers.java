package com.revature.models;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.Driver;
import com.revature.controllers.RegisterMenuController;
import com.revature.controllers.StartMenuController;

public class Customers {
	private String firstName;
	private String address;
	private String password = null;
	private String passConfirm;
	private boolean isRegistered = false;
	private boolean passMatch = false;
	private boolean loggedIn = false;
	private Scanner scan = new Scanner(System.in);
	private RegisterMenuController register = new RegisterMenuController();
	public StartMenuController startMenu;
	private Logger log = LoggerFactory.getLogger(Register.class);
	private String sSecurity;
	private int balance;
	private String lastName;

	public String getsSecurity() {
		return sSecurity;
	}

	public int getBalance() {
		return balance;
	}

	public Customers(String firstName, String lastName, String address, String password, String confirmAns) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.password = password;

		this.isRegistered = setConfirm(confirmAns);
	}

	public Customers() {
		super();
	}

//	public void createPlayer() {
//		customer=CustomerService.createNewCustomer(this.name,this.address,this.password);
//	}

	// Setters
	public void setLoggedIn() {

		while (this.loggedIn == false) {
			System.out.println("Enter your name");
			String name = scan.nextLine();
			if (this.firstName.equals(name)) {
				this.loggedIn = true;
			} else {
				System.out.println("incorrect user name fool.");
			}

		}
	}

	public void setLoggOff() {
		this.loggedIn = false;
	}

	public void setFirstName(String setName) {
		this.firstName = setName;
	}

	public void setLastName(String setLastName) {
		this.lastName = setLastName;
	}

	public void setAddress(String setAddress) {
		this.address = setAddress;
	}

	public void setPassword(String setPassword) {
//String pw = setPassword.length()> 2 ? this.password=setPassword :System.out.println("Password must be more than 2 characters long")

		while (this.password == null) {
			if (setPassword.length() <= 2) {
				log.warn("User tried to create password less than 2 characters");
				System.err.println("Password must be more than 2 characters long");
				System.out.println("What is your password?");
				String setPassword2 = scan.nextLine();
				setPassword(setPassword2);

			} else {
				this.password = setPassword;
			}

		}

	}

//	public String setPassConfirm(String setPassConfirm) {
//		while (!this.passMatch) {
//			if (!(this.password.equals(setPassConfirm))) {
//				log.warn("Passwords do not match, try again.");
//
////				System.err.println("Passwords do not match, try again.");
//				System.out.println("Confirm password");
//				String passAns = scan.nextLine();
//				setPassConfirm(passAns);
//
//			} else {
//				this.passMatch = true;
//
//			}
//		}
//		return setPassConfirm;
//
//	}

	public boolean setConfirm(String setConfirm) {
		return this.isRegistered = true;

	}

	// Getters
	public String getLastName() {
		return this.lastName;
	}

	public boolean getLoggedIn() {
		return this.loggedIn;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getAddress() {
		return this.address;
	}

	public String getPassWord() {
		return this.password;
	}

	public String getCustomer() {
		String details = "First name: " + this.firstName + "\n" + "Last name: " + this.getLastName() + "\n"
				+ "Address: " + this.address + "\n" + "Password: " + this.password;
		return details;
	}

	public String getPassConfirm() {
		return passConfirm;
	}

	public boolean isRegister() {
		return this.isRegistered;
	}

	public void setSocial(String sSecurity) {
		this.sSecurity = sSecurity;

	}

	public void setBalance(int balance) {
		this.balance = balance;

	}

	@Override
	public String toString() {
		return "[name=" + firstName + ", address=" + address + ", password=" + password + ", Social Security="
				+ sSecurity + ", starting balance=" + balance + "]";
	}

//	private String name;
//	private String password;
//	private String address;
//	private Register app;
//	private int checkingBalance;
//	private int savingBalance;
//
//	private static Logger log = LoggerFactory.getLogger(Customers.class);
//
////	public Customers() {
////		super();
////	};
//
//	public Customers(String name, String password, String address, int checkingBalance, int savingBalance) {
//		super();
//		this.name = name;
//		this.password = password;
//		this.address = address;
//		this.app = app;
//		if (checkingBalance >= 100) {
//			this.checkingBalance = checkingBalance;
//		} else {
//			log.warn(this.name + ", tried to start a checking accout with less than $100");
//		}
//
//		this.savingBalance = savingBalance;
//
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public Register getApp() {
//		return app;
//	}
//
//	public void setApp(Register app) {
//		this.app = app;
//	}
//
//	public int getCheckingBalance() {
//		return checkingBalance;
//	}
//
//	public void setCheckingBalance(int checkingBalance) {
//		if (checkingBalance >= 1) {
//			this.checkingBalance = checkingBalance;
//		} else {
//			log.warn(this.name + " , you must deposit positive amount at setter");
//		}
//	}
//
//	public int getSavingBalance() {
//		return savingBalance;
//	}
//
//	public void setSavingBalance(int savingBalance) {
//		this.savingBalance = savingBalance;
//	}

}
