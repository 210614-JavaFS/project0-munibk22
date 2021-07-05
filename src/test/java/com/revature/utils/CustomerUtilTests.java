package com.revature.utils;

import org.junit.jupiter.api.BeforeAll;

public class CustomerUtilTests {

	public static CustomerUtil customerUtil;
	public static int i;
	public static int result;

	@BeforeAll
	public static void setMathUtil() {
		System.out.println("In Before All");
		customerUtil = new CustomerUtil();
	}
}
