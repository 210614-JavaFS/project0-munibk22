package com.revature.services;

import java.util.ArrayList;
//import java.util.Scanner;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImp;
import com.revature.models.Customer;

public class CustomerService {
//	Customers customer;
	private static Logger log = LoggerFactory.getLogger(CustomerService.class);
	private static CustomerDAO customerDAO = new CustomerDAOImp();

	public Customer createRegCustomer(String firstName, String lastName, String userName, String password, int balance, String address, String sSecurity, boolean isRegistered, boolean isActive) {

		return new Customer(firstName, lastName, userName, password, balance, address, sSecurity, isRegistered,
				isActive);
	}

	public List<Customer> getAllCustomers() {
		return customerDAO.findAll();
	}

	public Customer getCustomer(int id) {
		return customerDAO.findById(id);
	}

	public boolean addCustomer(Customer customer) {
		 customerDAO.addCustomer(customer);
		 return true;
	}

	public void removeCustomer(String response) {
		customerDAO.deleteCustomer(response);
	}

	public void removeCustomerint(int id) {
		customerDAO.deleteCustomerid(id);
	}

	public void setDeposit(Customer customer, String deposit) {
//		customer.getBalance();
		System.out.println("Previous balance " + customer.getCheckingBalance());
		int parseDeposit = Integer.parseInt(deposit);
		if (parseDeposit != 0) {
			customer.setCheckingBalance(customer.getCheckingBalance() + parseDeposit);

			System.out.println("-----------------------------------");
			log.info("New balance " + customer.getCheckingBalance() + "\n");
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

//	public static void save(Customer customerReg) {
//		customerRDAO.writeCustomer(customerReg);
//
//	}

//	public ArrayList<Customer> getPreviousCustomerR() {
//
//		ArrayList<Customer> allCustomers = customerRDAO.getAllCustomers();
//		for (int i = 0; i < allCustomers.size(); ++i) {
//			if (allCustomers.get(i).getIsActive() == false) {
//				allCustomers.remove(i);
//			}
//		}
//		return allCustomers;
//	}

}
