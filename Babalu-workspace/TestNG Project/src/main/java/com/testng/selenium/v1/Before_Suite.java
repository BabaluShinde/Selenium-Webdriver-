package com.testng.selenium.v1;

import org.testng.annotations.*;

public class Before_Suite {
	
	@BeforeSuite
	public void beforesuit(){
		System.out.println("Test for befor_suite cases");
	}
	
	@Test
	public void signup() {
		System.out.println("Test for signup.");
	}
	@Test
	public void login() {
		System.out.println("Test for Login.");
	}
}
