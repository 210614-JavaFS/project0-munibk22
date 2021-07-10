package com.revature.models;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.RegisterMenuController;
import com.revature.controllers.StartMenuController;
import com.revature.services.CustomerService;

public class Register {
	private String name;
	private String address;
	private String password = null;
	private String passConfirm;
	private boolean isRegistered = false;
	private boolean passMatch = false;
	private Scanner scan = new Scanner(System.in);
	private RegisterMenuController register = new RegisterMenuController();
	public StartMenuController startMenu;
	private Logger log = LoggerFactory.getLogger(Register.class);

	public Register(String name, String address, String password, String passConfirm) {
		this.name = name;
		this.address = address;
		this.password = password;
		this.passConfirm = setPassConfirm(passConfirm);

	}

	public Register() {
		super();
	}

//	public void createPlayer() {
//		customer=CustomerService.createNewCustomer(this.name,this.address,this.password);
//	}

	// Setters
	public void setName(String setName) {
		this.name = setName;
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

//		setPassword(setPassword);
//		return setPassword;
	}

	public String setPassConfirm(String setPassConfirm) {
		// this.password=setPassConfirm;

		while (!this.passMatch) {
			if (!(this.password.equals(setPassConfirm))) {
				log.warn("Passwords do not match, try again.");

//				System.err.println("Passwords do not match, try again.");
				System.out.println("Confirm password");
				String passAns = scan.nextLine();
				setPassConfirm(passAns);

			} else {
				this.passMatch = true;
			}
		}
		return setPassConfirm;

	}

	public void setConfirm(String setConfirm) {
		if (setConfirm.equals("yes") || setConfirm.equals("1")) {
			System.out.println(this.isRegistered);

		} else {
			// this.setConfirm(setConfirm);
			// this.getPassConfirm();
//			register.registrationMenu();
		}

	}

	// Getters

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getPassWord() {
		return this.password;
	}

	public String getCustomer() {
		String details = "Name: " + this.name + "\n" + "Address: " + this.address + "\n" + "Password: " + this.password;
		return details;
	}

	public String getPassConfirm() {
		return passConfirm;
	}

	public boolean isRegister() {
		return this.isRegistered;
	}

}
