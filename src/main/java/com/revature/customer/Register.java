package com.revature.customer;

import java.util.Scanner;

import com.revature.controllers.RegisterMenu;
import com.revature.controllers.StartMenu;

public class Register {
	private String name;
	private String address;
	private String password;
	private String passConfirm;
	private boolean isRegistered=false;
	private boolean passMatch=false;
	private Scanner scan=new Scanner(System.in);
	private RegisterMenu register =new RegisterMenu();
	public StartMenu startMenu;
	
	public Register(String name,String address, String password,String passConfirm) {
		this.name=name;
		this.address=address;	
		this.password=password;
		this.passConfirm= setPassConfirm(passConfirm);
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

	if(setPassword.length() <= 2) {
		System.err.println("Password must be more than 2 characters long");
		//this.setPassword(setPassword);		
	}else {
		this.password=setPassword;
	}	
	}
	
	public String setPassConfirm(String setPassConfirm) {
		//this.password=setPassConfirm;
	
		while(!this.passMatch) {
			if(!(this.password.equals(setPassConfirm))) {
				System.err.println("Passwords do not match, try again.");
				System.out.println("Confirm password");
				String passAns= scan.nextLine();
				setPassConfirm(passAns);
				
			}else {
				this.passMatch=true;					
				}			
		}
		return setPassConfirm;
		
	}
	
public void setConfirm(String setConfirm) {	
		if(setConfirm.equals("yes") || setConfirm.equals("1")) {
			this.isRegistered=true;
			System.out.println(this.isRegistered);
			
		}else {		
			//this.setConfirm(setConfirm);
			//this.getPassConfirm();
			register.registrationMenu();
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
		String details= "Name: " +this.name+"\n"+"Address: "+ this.address+"\n"+
	"Password: "+ this.password;		
		return details;
	}

	public String getPassConfirm() {
		return passConfirm;
	}
	
	public boolean isRegister() {
			return this.isRegistered;
	}
	

	
	
}
