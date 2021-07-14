package com.revature.models;

public class Login {
	private String name;
	private String password;

	public Login(String name, String address, String password, String passConfirm) {
//		super(name, address, password, passConfirm);
		// TODO Auto-generated constructor stub
//		this.name = getName();
	}

	public void login() {
		System.out.println("in login method");
		System.out.println(this.name);
	}
}
