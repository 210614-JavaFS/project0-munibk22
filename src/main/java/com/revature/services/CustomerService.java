package com.revature.services;

import java.util.Scanner;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Customers;

public class CustomerService {
//	Customers customer;
	private static Logger log = LoggerFactory.getLogger(CustomerService.class);

//	public CustomerService(Customers customer2) {
//		// TODO Auto-generated constructor stub
//	}

	public static Customers createNewCustomer(String firstName, String lastName, String address, String password,
			String confirmAns) {
		return new Customers(firstName, lastName, address, password, confirmAns);
	}

	public void setDeposit(Customers customer, String deposit) {
//		customer.getBalance();
		System.out.println("Old balance " + customer.getBalance());
		int parseDeposit = Integer.parseInt(deposit);
		customer.setBalance(customer.getBalance() + parseDeposit);
		log.info("New balance " + customer.getBalance() + "\n");
	}
//	public static Object createNewCustomer(String name, String address, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public void withdraw(String response) {
		System.out.println(response);

	}

}
