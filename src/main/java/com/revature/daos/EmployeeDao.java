package com.revature.daos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Employee;

public class EmployeeDao {
	private Logger log = LoggerFactory.getLogger(EmployeeDao.class);

	public ArrayList<Employee> getAllEmployees() {

		ArrayList<Employee> employeeList = new ArrayList<>();

		try (Scanner scan = new Scanner(new File("src//main//resources//employees.txt"))) {

			while (scan.hasNextLine()) {
				String employeeString = scan.nextLine();
				String[] employeeDeets = employeeString.split(" , ");
				employeeList.add(new Employee(employeeDeets[0], employeeDeets[1], employeeDeets[2], employeeDeets[3],
						Integer.valueOf(employeeDeets[4])));

			}

		} catch (NullPointerException e) {
			System.out.println("Could not locate file:" + e.getMessage());
		} catch (IOException e) {
			log.error("Something went wrong retrieving employees:" + e.getMessage());
		}

		return employeeList;

	}
}
