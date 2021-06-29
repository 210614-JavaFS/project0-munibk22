package com.revature.customer;

public class Register {
	private String name;
	private String password;
	private String address;
	

	
	public Register(String name,String password, String address, int checkingBalance, int savingBalance) {
		this.name=name;
		this.password=password;
		this.address=address;		
		
	}
	
	//Setters
	public void setName(String setName) {
		this.name = setName;			
	}
	
	public void setAddress(String setAddress) {
		this.address=setAddress;
	}


}
