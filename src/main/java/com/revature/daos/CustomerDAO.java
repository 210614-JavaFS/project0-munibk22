package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDAO {
	public List<Customer> findAll();

	public Customer findById(String id);

	public boolean updateCustomer(Customer customer);

	public boolean addCustomer(Customer customer);

	public boolean deleteCustomer(String response);

	Customer findById(int id);

	int setId(String id);

	int deleteCustomerid(int id);

}
