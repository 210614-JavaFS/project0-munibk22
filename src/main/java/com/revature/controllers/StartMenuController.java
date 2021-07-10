package com.revature.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.RegisterCustomer;
import com.revature.services.CustomerService;

public class StartMenuController {

//	private RegisterMenuController registerMenu = new RegisterMenuController();
	private Logger log = LoggerFactory.getLogger(StartMenuController.class);
	private static Scanner scan = new Scanner(System.in);
	private static String ans;
	private static String setPassword;
	private static String setPassConfirm;
	private static boolean pwMatch = false;

	public RegisterCustomer getCustomer() {

//		do {
		System.err.println("Are you a current customer? yes/no");
		ans = scan.nextLine();
		try {

			if (ans.toLowerCase().equals("yes")) {
//				this.startMenu();
			} else if (ans.toLowerCase().equals("no")) {
				System.out.println("Great, let's get started with Registration. ");
				RegisterCustomer customerReg = newCustomerBuilder();
				return customerReg;
			}
//			else {
//				System.out.println("That is not a valid option, please choose again. \n");
//				return getCustomer();
//			}
		} catch (IllegalArgumentException e) {
			log.warn("User entered invalid  choice.");
			e.printStackTrace();
			System.out.println("Not a valid choice, please try again.");
//				return getCustomer();
		}
//		} while (!(ans == "yes") || !(ans == "no") || !(ans == "Yes") || !(ans == "No"));

		return getCustomer();

	}

	private RegisterCustomer newCustomerBuilder() {

//		registerMenu.registrationMenu();
//		Customers customer = new Customers();
		RegisterCustomer customerReg = null;
		System.err.println("\n****Registration Form****");

		System.out.println("What is your first name?");
		String setFirstName = scan.nextLine();
//		customer.setFirstName(setFirstName);
		System.out.println("What is your last name?");
		String setLastName = scan.nextLine();
//		customer.setLastName(setLastName);
		System.out.println("Please select a user name:");
		String userName = scan.nextLine();
		System.out.println("What is your address?");
		String setAddress = scan.nextLine();
//		customer.setAddress(setAddress);
		System.out.println("What is your password?");
		setPassword = scan.nextLine();
//		customer.setPassword(setPassword);
		do {
			System.out.println("Please confirm your password");
			setPassConfirm = scan.nextLine();
			passMatch(setPassword, setPassConfirm, setFirstName);
		} while (!pwMatch);

//		customer1 = new Register(nameAns, addressAns, passAns, passConfirmAns);
		System.err.println("\nPlease confirm your details:");
		System.out.println("Name: " + setFirstName + " " + setLastName + ",\n" + "Username: " + userName + ",\n"
				+ "Address: " + setAddress + ",\n" + "Password: " + setPassword);
		System.out.println("\nDoes everything look correct?");
		String confirmAns = scan.nextLine();
//		customer.setConfirm(confirmAns);
		if (confirmAns.toLowerCase().equals("yes") || confirmAns.equals("1")) {
			customerReg = CustomerService.createRegCustomer(setFirstName, setLastName, setAddress, setPassword,
					confirmAns, userName);
		} else {
			System.out.println("Alright, lets start over.");
			newCustomerBuilder();
		}

		if (customerReg.getRegistered()) {
			log.info("Customer " + customerReg.getFirstName() + " " + customerReg.getLastName() + " is registered. \n");
		}

		return customerReg;
	}

	private boolean passMatch(String pw, String confirmPW, String setFirstName) {
		if (pw.equals(confirmPW)) {
			return StartMenuController.pwMatch = true;
		} else {
			log.warn("User " + setFirstName + " did not enter a correct matching password.");
			System.err.println("Passwords do not match, please try again.");
			return StartMenuController.pwMatch = false;
		}

	}
}
