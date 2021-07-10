package com.revature.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class hourlyEmployee extends Employee {
	private static Logger log = LoggerFactory.getLogger(Employee.class);

	public hourlyEmployee(String firstName, String lastName, String department, boolean isLoggedIn, int id) {
		super(firstName, department, department, department, isLoggedIn, department, id);
	}

	public hourlyEmployee() {
		super();
	}

	//

}
