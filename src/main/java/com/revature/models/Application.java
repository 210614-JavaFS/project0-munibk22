package com.revature.models;

public class Application {
	private String name;
	private String address;
	private int checkingBalance;
	private int savingBalance;

	public Application() {
		super();
	}

	public Application(String name, String address, int checkingBalance, int savingBalance) {
		super();
		this.name = name;
		this.address = address;
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(int checkingBalance) {
		if (checkingBalance >= 100) {
			this.checkingBalance = checkingBalance;
		} else {
			System.out.println("Starting balance must be over $100");
		}
	}

	public int getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(int savingBalance) {
		this.savingBalance = savingBalance;
	}

}
