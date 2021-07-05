package com.revature.controllers;

import java.util.Scanner;

import com.revature.Driver;
import com.revature.models.Register;

public class RegisterMenu {
public Register customer1;
public StartMenu start;
public Scanner scan= new Scanner(System.in);

public void registrationMenu() {
	System.err.println("\nRegistration Form:");

	System.out.println("What is your name?");	
	String nameAns=scan.nextLine();		
	System.out.println("What is your address?");
	String addressAns=scan.nextLine();	
	System.out.println("What is your password?");
	String passAns= scan.nextLine();		
	System.out.println("Please confirm your password");
	String passConfirmAns= scan.nextLine();
	customer1 = new Register(nameAns, addressAns, passAns, passConfirmAns);
	System.err.println("\nPlease confirm your details:");
	System.out.println(customer1.getCustomer());
	System.out.println("Does everything look correct?");
	String confirmAns=scan.nextLine();
customer1.setConfirm(confirmAns);

if(customer1.isRegister()){
	//System.out.println("Customer " +customer1.getName()+" is registered.");
	System.err.println("\n"+customer1.getName()+", what would you like to do next:"	);
	System.out.println(	"1.Return to main menu \n"
			+"2.Open new account \n"
			+"3.Leave Bank");
	int ans = scan.nextInt();
	switch(ans) {
	case 1:
		Driver.initMenu.startMenu();
		break;
	case 2:
		System.out.println("Going to application for new account");
		break;		
	case 3:
		System.exit(0);
		break;
		default:
			Driver.initMenu.startMenu();
			break;
	}	
	}
}
}


