package com.revature.models;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.Driver;
import com.revature.controllers.RegisterMenuController;
import com.revature.controllers.StartMenuController;

public abstract class Character {
	private Logger log = LoggerFactory.getLogger(Register.class);
	private Scanner scan = new Scanner(System.in);
	private RegisterMenuController register = new RegisterMenuController();
	public StartMenuController startMenu;

	private String firstName;
	private String lastName;
	private String password = null;
	private String passConfirm;
	private boolean passMatch = false;
	private boolean isLoggedIn = false;
	private boolean isActive = false;
	private boolean isRegistered = false;


	public Character(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
//		this.setRegistered(setConfirm(confirmAns));
	}

	public Character() {
		super();
	}

//	public void createPlayer() {
//		customer=CustomerService.createNewCustomer(this.name,this.address,this.password);
//	}

	// Setters

	public void setLoggedIn() {

		while (this.isLoggedIn == false) {
			System.out.println("Enter your name");
			String name = scan.nextLine();
			if (this.firstName.equals(name)) {
				this.isLoggedIn = true;
			} else {
				System.out.println("incorrect user name fool.");
			}

		}
	}

	public void setLoggOff() {
		this.isLoggedIn = false;
	}

	public void setFirstName(String setName) {
		this.firstName = setName;
	}

	public void setLastName(String setLastName) {
		this.lastName = setLastName;
	}

	public void setPassword(String setPassword) {
//String pw = setPassword.length()> 2 ? this.password=setPassword :System.out.println("Password must be more than 2 characters long")

		while (this.password == null) {
			if (setPassword.length() <= 2) {
				log.warn("User tried to create password less than 2 characters");
				System.err.println("Password must be more than 2 characters long");
				System.out.println("What is your password?");
				String setPassword2 = scan.nextLine();
				setPassword(setPassword2);

			} else {
				this.password = setPassword;
			}

		}

	}

	// Getters
	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public boolean getLoggedIn() {
		return this.isLoggedIn;
	}

	public String getPassWord() {
		return this.password;
	}

	public String getPassConfirm() {
		return passConfirm;
	}

	// toString
	@Override
	public String toString() {
		return "Character [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", isLoggedIn=" + isLoggedIn + "]";
	}

	// HashCode & Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (isLoggedIn ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((log == null) ? 0 : log.hashCode());
		result = prime * result + ((passConfirm == null) ? 0 : passConfirm.hashCode());
		result = prime * result + (passMatch ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((register == null) ? 0 : register.hashCode());
		result = prime * result + ((scan == null) ? 0 : scan.hashCode());
		result = prime * result + ((startMenu == null) ? 0 : startMenu.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isLoggedIn != other.isLoggedIn)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (log == null) {
			if (other.log != null)
				return false;
		} else if (!log.equals(other.log))
			return false;
		if (passConfirm == null) {
			if (other.passConfirm != null)
				return false;
		} else if (!passConfirm.equals(other.passConfirm))
			return false;
		if (passMatch != other.passMatch)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (register == null) {
			if (other.register != null)
				return false;
		} else if (!register.equals(other.register))
			return false;
		if (scan == null) {
			if (other.scan != null)
				return false;
		} else if (!scan.equals(other.scan))
			return false;
		if (startMenu == null) {
			if (other.startMenu != null)
				return false;
		} else if (!startMenu.equals(other.startMenu))
			return false;
		return true;
	}

	/**
	 * @return the isActive
	 */
	public boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isRegistered
	 */
	public boolean getRegistered() {
		return isRegistered;
	}

	/**
	 * @param isRegistered the isRegistered to set
	 */
	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
//		return isRegistered;
	}

	public void setConfirm(String setConfirm) {
		this.setRegistered(true);

	}

//	public String setPassConfirm(String setPassConfirm) {
//	while (!this.passMatch) {
//		if (!(this.password.equals(setPassConfirm))) {
//			log.warn("Passwords do not match, try again.");
//
////			System.err.println("Passwords do not match, try again.");
//			System.out.println("Confirm password");
//			String passAns = scan.nextLine();
//			setPassConfirm(passAns);
//
//		} else {
//			this.passMatch = true;
//
//		}
//	}
//	return setPassConfirm;
//
//}

//	private Register app;

//	private int savingBalance;
//
//
//	public Customers(String name, String password, String address, int checkingBalance, int savingBalance) {
//		super();
//		this.name = name;
//		this.password = password;
//		this.address = address;
//		this.app = app;
//		if (checkingBalance >= 100) {
//			this.checkingBalance = checkingBalance;
//		} else {
//			log.warn(this.name + ", tried to start a checking accout with less than $100");
//		}
//
//		this.savingBalance = savingBalance;
//
//	}
//
//	public int getCheckingBalance() {
//		return checkingBalance;
//	}
//
//	public void setCheckingBalance(int checkingBalance) {
//		if (checkingBalance >= 1) {
//			this.checkingBalance = checkingBalance;
//		} else {
//			log.warn(this.name + " , you must deposit positive amount at setter");
//		}
//	}
//
//	public int getSavingBalance() {
//		return savingBalance;
//	}
//
//	public void setSavingBalance(int savingBalance) {
//		this.savingBalance = savingBalance;
//	}

}
