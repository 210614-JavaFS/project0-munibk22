package com.revature;

import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.BankMenuController;
import com.revature.controllers.StartMenuController;
import com.revature.models.BankCustomer;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class Driver {

//	private static Logger log = LoggerFactory.getLogger(Driver.class);
	private static Scanner scan = new Scanner(System.in);
	private static BankMenuController bankMenu = new BankMenuController();
	private static StartMenuController startMenuController = new StartMenuController();

	public static void main(String[] args) {
		System.out.println("*****Hello, Welcome to Revature2Vanquish Bank***** \n");
		EmployeeService employeeService=new EmployeeService();
		ArrayList<Employee> getEmployees = employeeService.getEmployees();
		int counter = 1;
		for(Employee employee:getEmployees) {
			System.out.println(counter + ") " + getEmployees);
			++counter;
		}
		Customer customerReg = startMenuController.getCustomer();
//		customerReg=startMenuController.saveCustomerReg(customerReg);
		// Initial start Menu
		initMenu(customerReg);
	}

	public static void initMenu(Customer customerReg) {
		while (customerReg.getRegistered()) {
			BankCustomer customerBank = new BankCustomer(customerReg.getFirstName(), customerReg.getLastName(),
					customerReg.getPassWord(), 200, "4241");
			System.out.println(
					"Customer " + customerBank.getFName() + " " + customerBank.getLastName() + " is registered. \n");
			bankMenu.bankMenu(customerBank);
			System.out.println("Do you want to leave the Bank?");
			String response = scan.nextLine();

			switch (response) {
			case "yes":
				// Save customer

				System.out.println("Saved customer Registration record");
				customerReg.setRegistered(false);
				break;
			case "no":
				customerBank.setReg(true);
				break;
			default:
				System.out.println("Not valid choice.");
				break;
			}
			customerReg = startMenuController.getCustomer();
			customerBank.setReg(true);
			customerBank = new BankCustomer(customerReg.getFirstName(), customerReg.getLastName(),
					customerReg.getPassWord(), 200, "4241");
			bankMenu.bankMenu(customerBank);
		}
	}

}

//log.debug("Fun times are aboot to start! msg");
//
//log.info("This is an awesome application");
//new
//log.error("Log something is going wrong");
//log.warn("The program is aboot to end");
//initMenu.startMenu();