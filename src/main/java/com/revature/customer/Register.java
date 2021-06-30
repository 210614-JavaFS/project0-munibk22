package com.revature.customer;

public class Register {
	private String name;
	private String password;
	private String address;
	private String passConfirm;
	private boolean isRegistered=false;
	

	
	public Register(String name,String address, String password,String passConfirm) {
		this.name=name;
		this.address=address;	
		this.password=password;
		this.passConfirm= passConfirm;
	}
	
	//Setters
	public void setName(String setName) {
		this.name = setName;			
	}
	
	public void setAddress(String setAddress) {
		this.address=setAddress;
	}
	
	public void setPassword(String setPassword) {
//String pw = setPassword.length()> 2 ? this.password=setPassword :System.out.println("Password must be more than 2 characters long")
this.setPassword(setPassword);
	if(setPassword.length() > 2) {
		this.password=setPassword;
	}else {
		System.err.println("Password must be more than 2 characters long");
		this.setPassword(setPassword);
	}	
	}
	
	public void setPassConfirm(String setPassConfirm) {
		this.passConfirm=setPassConfirm;
		if(this.password.equals(this.passConfirm)) {
			this.isRegistered=true;
			System.err.println("Please confirm following details:");
			System.out.println(this.getCustomer());
		}else {
			System.err.println("Passwords do not match, try again.");
			setPassConfirm(passConfirm);
		}
	}
	//Getters
	
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	public String getPassWord() {
		return this.password;
	}
	
	public String getCustomer() {
		String details= "Name: " +this.name+"\n"+"Address: "+ this.address+"\\n"+
	"Password: "+ this.password;		
		return details;
	}
}
