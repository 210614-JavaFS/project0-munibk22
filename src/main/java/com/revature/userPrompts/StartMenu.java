package com.revature.userPrompts;

import java.util.Scanner;

public class StartMenu {

	public void startMenu() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("\n*****Hello, Welcome to Revature2Vanquish Bank***** \n" + "\n" + 
					"What would you like to do today? \n"
					+ "1.Register" + "\n2.Login" + "\n3.Open a new account" + "\n4.Exit the bank");
			int ans = scan.nextInt();

			switch (ans) {
			case 1:
				System.out.println("Great, let's get started with Registration.");
				break;
			
			case 2:
				System.out.println("Great, let's login to your account.");
				break;
			case 3:
				System.out.println("Excellent, let's get started with your new account.");
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
