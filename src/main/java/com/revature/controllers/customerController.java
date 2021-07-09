package com.revature.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Customers;
import com.revature.services.CustomerService;

import jdk.internal.org.jline.utils.Log;

public class customerController {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(customerController.class);

	public static void getTransactionsMenu(Customers customer) {
		CustomerService customerService = new CustomerService();
		String ans;
		boolean menuController = true;

		System.err.println("Good news, " + customer.getFirstName() + " loggin was successfull!");

		do {
			System.out.println("What would you like to do today?");
			System.out.println("1.Make a deposit");
			System.out.println("2.Make a withdrawal");
			System.out.println("3.Transfer funds between your accounts");
			System.out.println("4.");
			System.out.println("7.Exit menu");

			ans = scan.nextLine();
			switch (ans) {
			case "1":
				System.out.println("Enter amount to deposit:");
				String deposit = scan.nextLine();
				if (Integer.parseInt(deposit) > 0) {
					customerService.setDeposit(customer, deposit);
				} else {
					log.info(customer.getFirstName() + " tried to deposit an amount below 0.");
					System.err.println("Must deposit an amount over $0 \n");
				}

//			System.out.println("Customer has deposited " + deposit + "into " + customer.getBalance());
				break;
			case "2":
				System.out.println("Enter amount you would like to withdraw:");
				String response = scan.nextLine();
//				response = Integer.parseInt(response);
				if (Integer.parseInt(response) > customer.getBalance()) {
					log.warn(customer.getFirstName()
							+ " tried to withdraw an amount greater than avialable in account.");
					System.err.println("You do not have enough funds to withdraw $" + response);
				} else {
					customerService.withdraw(response);
				}
				break;
			case "7":
				menuController = false;
//				customer.setLoggOff();
				break;
			default:
				log.warn("User entered invalid  choice.");
				System.out.println("Not a valid choice, please try again.");
//				customer.setLoggOff();
				break;
			}

		} while (menuController);
//		while (customer.getLoggedIn());

	}

}
