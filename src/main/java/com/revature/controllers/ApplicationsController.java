package com.revature.controllers;

//import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import com.revature.models.RegisterCustomer;

public class ApplicationsController {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(ApplicationsController.class);

	public BankCustomer getAppMenu(BankCustomer customerBank) {
		System.err.println("Welcome " + customerBank.getFirstName() + " to the new accout application");

		try {
//			System.out.println("You can: \n" + "1.Apply \n" + "4.Back to main menu. \n");
			System.out.println("Enter last 4 digits of social security number");
			String sSecurity = scan.nextLine();
//			customer.setSocial(sSecurity);
			System.out.println("Enter starting checking balance");
			int balance = scan.nextInt();
//			customer.setBalance(balance);

			System.out.println("Review details before submitting:");
			System.err.println("Customer " + customerBank.getFirstName() + " details:");
			System.out.println(customerBank.toString());

//			System.out.println("\nYou can: \n" + "1.Submit Application \n" + "4.Back to main menu. \n");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			log.warn("User entered invalid input");
		}
		return customerBank;
	}
}
