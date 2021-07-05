package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.StartMenu;

public class Driver {

	private static Logger log = LoggerFactory.getLogger(Driver.class);

	public static StartMenu initMenu = new StartMenu();

	public static void main(String[] args) {
		// Initial start Menu
		log.debug("Fun times are aboot to start! msg");

		log.info("This is an awesome application");

		log.error("Log something is going wrong");
		log.warn("The program is aboot to end");
		initMenu.startMenu();
		
		
	}
}
