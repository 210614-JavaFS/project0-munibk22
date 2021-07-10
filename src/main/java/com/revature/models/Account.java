package com.revature.models;

public class Account {
	private int accountNo;
	private static int saccNo = 1000;

	public Account() {
		super();
		this.accountNo = saccNo++;
		System.out.println("Accout " + this.accountNo + " was approved!");

	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public static int getSaccNo() {
		return saccNo;
	}

	public static void setSaccNo(int saccNo) {
		Account.saccNo = saccNo;
	}

	// toString
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + "]";
	}

}
