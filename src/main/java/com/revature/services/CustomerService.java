package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.CustomerRDAO;
import com.revature.models.BankCustomer;
import com.revature.models.Customer;

public class CustomerService {
//	Customers customer;
	private static Logger log = LoggerFactory.getLogger(CustomerService.class);
	private static CustomerRDAO customerRDAO = new CustomerRDAO();

	public Customer createRegCustomer(String firstName, String setLastName, String setAddress, String setPassword,
			String userName) {

		return new Customer(firstName, setLastName, setPassword, setAddress, userName);
	}

//	public CustomerService(Customers customer2) {
//		// TODO Auto-generated constructor stub
//	}

//	public static RegisteredCustomer createNewCustomer(String firstName, String lastName, String address, String password,
//			String confirmAns) {
//		return new Customers(firstName, lastName, address, password, confirmAns);
//	}

	public void setDeposit(BankCustomer customerBank, String deposit) {
//		customer.getBalance();
		System.out.println("Previous balance " + customerBank.getCheckingBalance());
		int parseDeposit = Integer.parseInt(deposit);
		if (parseDeposit != 0) {
			customerBank.setCheckingBalance(customerBank.getCheckingBalance() + parseDeposit);

			System.out.println("-----------------------------------");
			log.info("New balance " + customerBank.getCheckingBalance() + "\n");
			System.out.println("-----------------------------------");
		} else {
			System.out.println("Must deposit an amount greater than $0");
		}

	}
//	public static Object createNewCustomer(String name, String address, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public void withdraw(String response) {
		System.out.println(response);

	}

	public static void save(Customer customerReg) {
		customerRDAO.writeCustomer(customerReg);

	}

	public ArrayList<Customer> getPreviousCustomerR() {

		ArrayList<Customer> allCustomers = customerRDAO.getAllCustomers();
		for (int i = 0; i < allCustomers.size(); ++i) {
//			if (allCustomers.get(i).getIsActive() == false) {
//				allCustomers.remove(i);
//			}
		}
		return allCustomers;
	}

}
