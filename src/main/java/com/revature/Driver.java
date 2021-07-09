package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.BankMenuController;
import com.revature.controllers.StartMenuController;
import com.revature.models.Customers;

public class Driver {

	private static Logger log = LoggerFactory.getLogger(Driver.class);

	public static void main(String[] args) {
		// Initial start Menu
		System.out.println("*****Hello, Welcome to Revature2Vanquish Bank***** \n");
		StartMenuController startMenuController = new StartMenuController();
		BankMenuController bankMenu = new BankMenuController();
//		log.debug("Fun times are aboot to start! msg");
//
//		log.info("This is an awesome application");
//new
//		log.error("Log something is going wrong");
//		log.warn("The program is aboot to end");
//		initMenu.startMenu();

		Customers customer = startMenuController.getCustomer();
		while (customer.isRegister()) {
//			System.out.println("Customer " + customer.getName() + " is registered. \n");

			bankMenu.bankMenu(customer);
		}

	}
	
}
