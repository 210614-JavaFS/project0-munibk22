package com.revature.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.BankCustomer;
import com.revature.models.Customer;

public class BankMenuController {

	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(BankMenuController.class);

	public void bankMenu(BankCustomer customerBank) {

		while (customerBank.getReg()) {

			ApplicationsController appController = new ApplicationsController();
			System.out.println("***** Welcome " + customerBank.getFirstName() + " to Revature2Vanquish Bank***** \n");

			System.out.println("What would you like to do today?");
			System.out.println("1.Submit application for new account" + "\n2.Apply for a new account" + "\n3.Login"
					+ "\n4.Exit the Bank" + "\n5.Exit the Game");

			String answer = scan.nextLine();

			switch (answer) {
			case "1":
//				if (!customerBank.isRegistered()) {
				System.out.println("Excellent, " + customerBank.getFirstName()
						+ " let's submit your application for approval. Most accounts are approved within 24 hours. ");
//				customer = appController.getAppMenu(customer);
//				registerMenu.registrationMenu();
				break;
//				} else {
//					System.out.println("\nYou can: \n" + "1.Submit Application");
////					System.out.println(customerReg.getBalance());
//					break;
//				}

			case "2":
				System.out.println(
						"Excellent, " + customerBank.getFirstName() + " let's get started with your new account. \n");
				customerBank = appController.getAppMenu(customerBank);
				break;
			case "3":
				System.out.println("Great, let's login to your account.");
				login(customerBank);

				break;
			case "4":
				System.out.println("Thank you for visiting!");
				customerBank.setReg(false);
				break;
			case "5":
				System.out.println("Thank you for visiting!");
				System.exit(0);
				break;
			default:
				log.warn("User entered invalid  choice.");
				System.out.println("Not a valid choice, please try again.");
				bankMenu(customerBank);
				break;
			}

//		try (Scanner scan2 = new Scanner(System.in)) {
//

//			}
//		} catch (Exception e) {
//			log.warn("User entered invalid  choice.");
////			e.printStackTrace();
//			System.out.println("Not a valid choice, please try again.");
//			startMenu(customer);
//
//		}
		}
	}

	private void login(BankCustomer customerBank) {

		customerBank.setLoggedIn();
		boolean menuController = true;
//BankCustomer customerBank = new BankCustomer(customerBank.getFirstName(), customerBank.getLastName(),
//				customerBank.getPassWord(), 200, "4241");
		while (menuController) {
//			CustomerUtil.customerUtil(customer);
			if (customerBank.getLoggedIn()) {
				System.out.println(
						customerBank.getFirstName() + customerBank.getLastName() + " was logged out successfully! \n");
				customerBank = CustomerController.getTransactionsMenu(customerBank);
			}
			menuController = false;

		}

	}
}
