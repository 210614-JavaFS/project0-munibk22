package com.revature.models;

import com.revature.Driver;

public abstract class Room {
	public String shortDesc;
	public String longDesc;

	public void returnMainMenu() {
		Driver.initMenu.startMenu();
	}
}
