package com.testng.selenium.v1;

import org.testng.Assert;
import org.testng.annotations.Test;
public class HardAssertionExample {

	@Test
	public void testHardAssert(){
		
		int actual=5;
		int expected=10;
		
		Assert.assertEquals(actual, expected, "Actaul value does not match the expected value");
		
		System.out.println("This line will not executed if the assertion fails.");
		
		
		
	}
}
