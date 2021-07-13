package com.revature.models;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankCustomer extends Character {
	private static Scanner scan = new Scanner(System.in);
	private static Logger log = LoggerFactory.getLogger(Character.class);

	private int checkingBalance;
	private Account account;
	private String sSecurity;
	private boolean reg = true;

//	public BankCustomer(String firstName, String lastName, String password, int checkingBalance, String sSecurity) {
//		super(firstName, lastName, password);
//		this.checkingBalance = checkingBalance;
////		this.account = account;
//		this.sSecurity = sSecurity;
////		this.setRegistered(setConfirm(confirmAns));
////		this.reg=setReg(setRegistered);
//	}

//	public BankCustomer() {
//		super();
//	}
//getters 

	public int getCheckingBalance() {
		return checkingBalance;
	}

	public Account getAccount() {
		return account;
	}

	public String getsSecurity() {
		return sSecurity;
	}

	public String getFName() {
		return getFirstName();
	}

	public boolean getReg() {
		return this.reg;
	}

	// setters

//	public void setConfirm(String setConfirm) {
//		 this.setRegistered(true);
//
//	}

	public void setReg(boolean setRegistered) {
		this.reg = setRegistered;
	}

	public void setCheckingBalance(int checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setsSecurity(String sSecurity) {
		this.sSecurity = sSecurity;
	}

	// toString
	@Override
	public String toString() {
		return "BankCustomer [checkingBalance=" + checkingBalance + ", account=" + account + ", sSecurity=" + sSecurity
				+ ", getLastName()=" + getLastName() + ", getFirstName()=" + getFirstName() + ", getLoggedIn()="
				+ getLoggedIn() + ", getPassWord()=" + getPassWord() + "]";
	}

	// HashCode & Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + checkingBalance;
		result = prime * result + ((sSecurity == null) ? 0 : sSecurity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankCustomer other = (BankCustomer) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (checkingBalance != other.checkingBalance)
			return false;
		if (sSecurity == null) {
			if (other.sSecurity != null)
				return false;
		} else if (!sSecurity.equals(other.sSecurity))
			return false;
		return true;
	}

}
