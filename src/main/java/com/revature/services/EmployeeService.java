package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;
import com.revature.models.Customer;

public class EmployeeService {
	private EmployeeDao employeeDao = new EmployeeDao();

	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> employees = employeeDao.getAllEmployees();
		// int empIndex=
		for (int i = 0; i < employees.size(); i++) {

		}
		return employees;
	}

	public void removeCustomer(Employee employee, Customer customer) {

	}

}
