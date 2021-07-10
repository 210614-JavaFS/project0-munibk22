package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.BankCustomer;
import com.revature.controllers.BankMenuController;
import com.revature.controllers.StartMenuController;
import com.revature.models.Account;
import com.revature.models.RegisterCustomer;

public class Driver {

//	private static Logger log = LoggerFactory.getLogger(Driver.class);
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// Initial start Menu
		System.out.println("*****Hello, Welcome to Revature2Vanquish Bank***** \n");
		StartMenuController startMenuController = new StartMenuController();
		BankMenuController bankMenu = new BankMenuController();

//		List<Account> accntList = new ArrayList<>();
//		log.debug("Fun times are aboot to start! msg");
//
//		log.info("This is an awesome application");
//new
//		log.error("Log something is going wrong");
//		log.warn("The program is aboot to end");
//		initMenu.startMenu();

		RegisterCustomer customerReg = startMenuController.getCustomer();
		BankCustomer customerBank = new BankCustomer(customerReg.getFirstName(), customerReg.getLastName(),
				customerReg.getPassWord(), 200, "4241");

		while (customerReg.getRegistered()) {
			System.out.println(
					"Customer " + customerBank.getFName() + " " + customerBank.getLastName() + " is registered. \n");
			bankMenu.bankMenu(customerBank);
			System.out.println("Do you want to leave the Bank?");
			String response = scan.nextLine();

			switch (response) {
			case "yes":
				customerReg.setRegistered(false);
				startMenuController.getCustomer();
				break;
			case "no":
				customerBank.setReg(true);
				break;
			default:
				System.out.println("Not valid choice.");
				break;
			}
		}

	}

}
