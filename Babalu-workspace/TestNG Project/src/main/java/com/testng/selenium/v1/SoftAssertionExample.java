package com.testng.selenium.v1;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
public class SoftAssertionExample {

	@Test
	void SoftAssertiontest() {
		SoftAssert softassert=new SoftAssert();
		int actual=5;
		int expected=10;
		
		softassert.assertEquals(actual, expected,"Actual value does not match the expected value.");
		System.out.println("This line will executed even if the assertion fails...");
		softassert.assertAll();
	}
}
