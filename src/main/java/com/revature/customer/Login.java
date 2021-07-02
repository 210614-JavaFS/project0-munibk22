package com.revature.customer;

public class Login extends Register{
	private String name;
	private String password;
	
	public Login(String name, String address, String password, String passConfirm) {
		super(name, address, password, passConfirm);
		// TODO Auto-generated constructor stub
		this.name=super.getName();
	}






	public void login() {
		System.out.println("in login method");
		System.out.println(this.name);
	}
}
