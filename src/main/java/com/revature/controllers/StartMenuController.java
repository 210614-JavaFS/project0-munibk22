package com.revature.controllers;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Employee;
import com.revature.models.Customer;
import com.revature.services.CustomerService;

public class StartMenuController {

//	private RegisterMenuController registerMenu = new RegisterMenuController();
	private Logger log = LoggerFactory.getLogger(StartMenuController.class);
	private static Scanner scan = new Scanner(System.in);
	private static String ans;
	private static String setPassword;
	private static String setPassConfirm;
	private static boolean pwMatch = false;
	private static CustomerService customerService = new CustomerService();

	public Customer getCustomer() {
//		do {

//				String choice = scan.nextLine();
//				try {
//					int intChoice = Integer.valueOf(choice);
//					Customer customerR = activeCustomers.get(intChoice - 1);
//					System.out.println("Welcome back " + customerR.getFirstName() + " " + customerR.getLastName());
//					return customerR;
//				} catch (NumberFormatException e) {
//					log.warn("User tried to select customer that does not currently exists " + e.getMessage());
//					System.out.println("Not valid input, please try again.");
//					return getCustomer();
//				}

		System.out.println("Are you a current Customer?");
		String response = scan.nextLine();
		if (response.equals("yes")) {
			System.out.println("Welcome to customer login");
		} else if (response.toLowerCase().equals("no")) {
			System.out.println("\nGreat, let's get started with Registration. ");
			Customer customerReg = newCustomerBuilder();
			return customerReg;
		} else {
			System.out.println("That is not a valid option, please choose again. \n");
			return getCustomer();
		}
		return null;
	}
//catch(IllegalArgumentException e)
//	{
//			log.warn("User entered invalid  choice.");
//			e.printStackTrace();
//			System.out.println("Not a valid choice, please try again.");
////				return getCustomer();
//		}
//		} while (!(ans == "yes") || !(ans == "no") || !(ans == "Yes") || !(ans == "No"));

//	return null;

//	}

	public Customer newCustomerBuilder() {

		Customer customer = new Customer();
		System.err.println("\n****Registration Form****");

		System.out.println("What is your first name?");
		String setFirstName = scan.nextLine();
		customer.setFirstName(setFirstName);
		System.out.println("What is your last name?");
		String setLastName = scan.nextLine();
		customer.setLastName(setLastName);
		System.out.println("Please select a user name:");
		String userName = scan.nextLine();
		customer.setUserName(userName);
		System.out.println("What is your address?");
		String setAddress = scan.nextLine();
		customer.setAddress(setAddress);
		System.out.println("What is your password?");
		setPassword = scan.nextLine();
		customer.setPassword(setPassword);
		do {
			System.out.println("Please confirm your password");
			setPassConfirm = scan.nextLine();
			passMatch(setPassword, setPassConfirm, setFirstName);
		} while (!pwMatch);

		System.err.println("\nPlease confirm your details:");
		System.out.println("Name: " + setFirstName + " " + setLastName + ",\n" + "Username: " + userName + ",\n"
				+ "Address: " + setAddress + ",\n" + "Password: " + setPassword);
		System.out.println("\nDoes everything look correct?");
		String confirmAns = scan.nextLine();
//		customer.setConfirm(confirmAns);saveCustomerReg
		if (confirmAns.toLowerCase().equals("yes") || confirmAns.equals("1") || confirmAns.equals("ye")) {
			customer.setConfirmAns(confirmAns);
			customer.setRegistered(true);
		} else {
			System.out.println("Alright, lets start over.");
			customer = newCustomerBuilder();
		}

		if (customer.getRegistered()) {

			log.info("Customer " + customer.getFirstName() + " " + customer.getLastName() + " is registered. \n");
		}
//		saveCustomerReg(customerReg);
		return customer;
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

//	public void saveCustomerReg(Customer customerReg) {
//		CustomerService.save(customerReg);
//
//	}
}
