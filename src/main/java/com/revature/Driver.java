package com.revature;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.controllers.AccountController;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.revature.controllers.BankMenuController;
import com.revature.controllers.CustomerController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.StartMenuController;
import com.revature.models.BankCustomer;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;
import com.revature.utils.ConnectionUtil;

public class Driver {

//	private static Logger log = LoggerFactory.getLogger(Driver.class);
	private static Scanner scan = new Scanner(System.in);
	private static BankMenuController bankMenu = new BankMenuController();
	private static StartMenuController startMenuController = new StartMenuController();
	private static EmployeeService employeeService = new EmployeeService();
	private static CustomerService customerService = new CustomerService();
	private static CustomerController customerController = new CustomerController();
	private static EmployeeController empController = new EmployeeController();
	private static AccountController accountController = new AccountController();

	public static void main(String[] args) {

//		customerController.addCustomer();
//		customerService.getAllCustomers();

		
		// Initial start Menu		
		initialPrompt();
		

		Customer customer = startMenuController.getCustomer();
		
		initMenu(customer);

//		customerReg=startMenuController.saveCustomerReg(customerReg);

	}
	

	private static void initialPrompt() {
		String ans = null;
		do {
			System.out.println("\n*****Hello, Welcome to Revature2Vanquish Bank***** \n");
			System.err.println("Are you a current employee? yes/no");
			ans = scan.nextLine();
			if (ans.toLowerCase().equals("yes") || ans.toLowerCase().equals("ye")) {
				queryEmployee();
			}
		} while (!ans.equals("no"));
		
	}


	public static void queryEmployee() {
		empController.employeeLogin();
	}

	public static void initMenu(Customer customerReg) {
		while (customerReg.getRegistered()) {
//			BankCustomer customerBank = new BankCustomer(customerReg.getFirstName(), customerReg.getLastName(),
//					customerReg.getPassWord(), 200, "4241");
			System.out.println(
					"Customer " + customerReg.getFirstName() + " " + customerReg.getLastName() + " is registered. \n");
			bankMenu.bankMenu(customerReg);
			System.out.println("Do you want to leave the Bank?");
			String response = scan.nextLine();

			switch (response) {
			case "yes":
				// Save customer
				customerReg.setRegistered(false);
				
				break;
			case "no":
				customerReg.setReg(true);
				break;
			default:
				System.out.println("Not valid choice.");
				break;
			}
			initialPrompt();
			customerReg.setReg(true);
//			customerReg = new Customer(customerReg.getFirstName(), customerReg.getLastName(),
//					customerReg.getPassWord(), 200, "4241");
			bankMenu.bankMenu(customerReg);
		}
	}

}

//log.debug("Fun times are aboot to start! msg");
//
//log.info("This is an awesome application");
//new
//log.error("Log something is going wrong");
//log.warn("The program is aboot to end");
