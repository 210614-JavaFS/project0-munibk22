package com.revature.controllers;

import java.util.Scanner;

public class StartMenu {
private RegisterMenu registerMenu = new RegisterMenu();

	public void startMenu() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("\n*****Hello, Welcome to Revature2Vanquish Bank***** \n" ); 
			System.err.println("What would you like to do today?");
			System.out.println("1.Register" + "\n2.Open a new account" + "\n3.Login" + "\n4.Exit the bank");
			int ans = scan.nextInt();

			switch (ans) {
			case 1:
				System.out.println("Great, let's get started with Registration. ");
				registerMenu.registrationMenu();
				break;
			
			case 2:
				System.out.println("Excellent, let's get started with your new account.");
				break;
			case 3:
				System.out.println("Great, let's login to your account.");
				break;
			case 4:
				System.out.println("Thank you for visiting!");
				System.exit(0);
				default:
					System.out.println("Not a valid choice, please try again.");
					startMenu();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
