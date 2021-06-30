package com.revature.userPrompts;

import java.util.Scanner;

import com.revature.customer.Register;

public class RegisterMenu {
public Register register;

public void registrationMenu() {
System.err.println("\nRegistration Form:");
try(Scanner scan= new Scanner(System.in)) {
	System.out.println("What is your name?");
	String nameAns=scan.nextLine();	
	System.out.println("What is your address?");
	String addressAns=scan.nextLine();
	System.out.println("What is your password?");
	String passAns= scan.nextLine();	
	System.out.println("Please confirm your password");
	String passConfirmAns= scan.nextLine();
	
	register = new Register(nameAns, addressAns, passAns, passConfirmAns);
	//System.out.println(	register.getCustomer());

} catch (Exception e) {
	e.getStackTrace();
}
}
}
