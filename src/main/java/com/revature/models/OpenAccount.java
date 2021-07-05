package com.revature.models;

public class OpenAccount {
	private int checkingBalance;
	private int savingBalance;
	
	
	public void setChecking(int setChecking) {
		if(setChecking <=100) {
			System.out.println("Must have a starting balance greater than $100.");
			}else {
			this.checkingBalance =setChecking;
		}
	}

	public void setSaving(int setSaving) {
		if(setSaving <0) {
			System.out.println("Must have a starting balance greater than $0.");
			
		}else {
			this.savingBalance =setSaving;
		}
	}
}
