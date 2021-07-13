package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImp;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.services.AccountService;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;

public class EmployeeController {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(CustomerController.class);
	private static CustomerService customerService = new CustomerService();
	private static boolean pwMatch = false;
	private static String setPassConfirm;
	private static String setPassword;
	private static CustomerController customerController = new CustomerController();
	private static CustomerDAO customerDAO = new CustomerDAOImp();
	private static AccountService accountService = new AccountService();
	private static EmployeeService employeeService = new EmployeeService();

	public Employee employeeLogin(Employee employee) {

		System.out.println("Enter username");
		String userNameScan = scan.nextLine();
		System.out.println("Enter password");
		String passwordScan = scan.nextLine();

		employee = employeeService.getEUserName(userNameScan);
		System.out.println(employee);
		scan.nextLine();
		employee.setLoggedIn();
//		employeeMenu(employee);
		return employee;
	}

	public Employee employeeMenu(Employee employee) {

		String ans;
		boolean menuController = true;

		System.err.println("Good news, " + employee.getFirstName() + " loggin was successfull!\n");

		do {
			System.out.println("What would you like to do today?");
			System.out.println("1.Make a deposit");
			System.out.println("2.Make a withdrawal");
			System.out.println("3.Transfer funds between your accounts");
			System.out.println("4.Remove a customer");
			System.out.println("5.See all customers");
			System.out.println("6.See one customer");
			System.out.println("7.Add a customer");
			System.out.println("8.View accounts pending approval");
			System.out.println("9.Account information");
			System.out.println("10.View account balances");
			System.out.println("11.Personal information");
			System.out.println("12.See all accounts");
			System.out.println("13.Exit menu");

			ans = scan.nextLine();
			switch (ans) {
			case "1":
				System.err.println("Enter amount to deposit:");
				String deposit = scan.nextLine();
				if (Integer.parseInt(deposit) > 0) {

				} else {
//					log.info(customer.getFirstName() + " tried to deposit an amount below 0.");
					System.err.println("Must deposit an amount over $0 \n");
				}

//			System.out.println("Customer has deposited " + deposit + "into " + customer.getBalance());
				break;
			case "2":
				System.out.println("Enter amount you would like to withdraw:");
//				String response = scan.nextLine();
//				response = Integer.parseInt(response);
//				if (Integer.parseInt(response) > customer.getCheckingBalance()) {
//					log.warn(customer.getFirstName()
//							+ " tried to withdraw an amount greater than avialable in account. ");
//					System.err.println("You do not have enough funds to withdraw $" + response + "\n");
//				} else {
//					customerService.withdraw(response);

				break;
			case "3":

				break;
			case "4":
				deleteCustomer();
				break;
			case "5":
				showAllCustomers();
				break;
			case "6":
				this.showOneCustomer();
				break;
			case "7":
				addCustomer();
				break;
			case "8":
				showStatus();
				break;
			case "9":

				break;
			case "10":
				showAllAccounts();
				break;
			case "11":

				break;
			case "12":
//				showAllAccounts();
				break;
			case "13":
				menuController = false;
//				customer.setLoggOff();
				break;
			default:
				log.warn("User entered invalid  choice.");
				System.err.println("Not a valid choice, please try again.\n");
				break;

			}

		} while (menuController);

		return null;

	}

	private void showStatus() {
		List<Customer> customers = employeeService.getStatus();
		System.err.println("\nHere are the customer accounts pending approval:");
		System.out.println("==========");
		for (Customer c : customers) {
			System.out.println(c);
		}
		System.out.println("========== \n");

		System.out.println("Do you want to approve any accounts?");
		String response = scan.nextLine();
		if (response.equals("yes")) {

			approveAccounts();
		}

	}

//	public void addCustomer() {
//		System.err.println("\n****Registration Form****");
//
//		System.out.println("What is your first name?");
//		String setFirstName = scan.nextLine();
////		customer.setFirstName(setFirstName);
//		System.out.println("What is your last name?");
//		String setLastName = scan.nextLine();
////		customer.setLastName(setLastName);
//		System.out.println("Please select a user name:");
//		String userName = scan.nextLine();
//		System.out.println("What is your address?");
//		String setAddress = scan.nextLine();
////		customer.setAddress(setAddress);
//		System.out.println("What is your password?");
//		setPassword = scan.nextLine();
////		customer.setPassword(setPassword);
//		do {
//			System.out.println("Please confirm your password");
//			setPassConfirm = scan.nextLine();
//			passMatch(setPassword, setPassConfirm, setFirstName);
//		} while (!pwMatch);
//		Customer customer = new Customer(setFirstName, setLastName, userName, setAddress, setPassword);
//		if (customerService.addCustomer(customer)) {
//			System.out.println("New customer " + customer.getFirstName() + " was added.");
//		} else {
//			System.out.println("Problem adding customer, please try again");
//		}
//	}

	private void approveAccounts() {
		boolean customers = employeeService.updateActive();
		System.err.println("\nEnter customer user name");
		String response = scan.nextLine();
		System.out.println("==========");
//		for (Customer c : customers) {
//			System.out.println(c);
//		}
		System.out.println("========== \n");

	}

	public void addCustomer() {
		StartMenuController menuController = new StartMenuController();
		menuController.newCustomerBuilder();
	}

	public void showAllAccounts() {
		List<Account> accounts = employeeService.getAllAccounts();
		System.err.println("\nHere are the recorded accounts:");
		System.out.println("==========");

		for (Account a : accounts) {
			System.out.println(a);
		}
		System.out.println("==========\n");
	}

	public void showAllCustomers() {
		List<Customer> customers = employeeService.getAllCustomers();
		System.err.println("\nHere are the recorded customers:");
		System.out.println("==========");
		for (Customer c : customers) {
			System.out.println(c);
		}
		System.out.println("========== \n");
	}

	public List<Customer> getAllCustomers() {
		return customerDAO.findAll();
	}

	public void showOneCustomer() {
		System.out.println("Enter first name of the customer you would like to see?");
		String response = scan.nextLine();

		Customer customer = employeeService.getName(response);

		if (customer != null) {
			System.out.println(customer);
		} else {
			System.out.println("That is not a valid customer name, try again.");
			showOneCustomer();
		}

	}

	public static boolean passMatch(String pw, String confirmPW, String setFirstName) {
		if (pw.equals(confirmPW)) {
			return pwMatch = true;
		} else {
			log.warn("User " + setFirstName + " did not enter a correct matching password.");
			System.err.println("Passwords do not match, please try again.");
			return pwMatch = false;
		}

	}

	public void deleteCustomer() {
		System.out.println("Enter id name of the customer you want to remove?");

		int response = scan.nextInt();
//		Customer customer = customerService.removeCustomerint(response);
		customerService.removeCustomerint(response);
//		if (customer != null) {
//			System.out.println(customer);
//		} else {
//			System.out.println("That is not a valid customer name, try again.");
//			showOneCustomer();
//		}
	}

}
