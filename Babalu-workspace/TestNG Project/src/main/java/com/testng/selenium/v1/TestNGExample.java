package com.testng.selenium.v1;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
public class TestNGExample {
	
	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("Before Class - This runs once before any test methods in the class.");
	    }

	    @AfterClass
	    public void afterClass() {
	        System.out.println("After Class - This runs once after all test methods in the class.");
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("Before Method - This runs before each test method.");
	    }

	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("After Method - This runs after each test method.");
	    }

	    @Test
	    public void testAddition() {
	        int sum = 5 + 3;
	        Assert.assertEquals(sum, 8, "Addition test failed");
	        System.out.println("Test 1: Addition test passed.");
	    }

	    @Test
	    public void testSubtraction() {
	        int difference = 5 - 3;
	        Assert.assertEquals(difference, 2, "Subtraction test failed");
	        System.out.println("Test 2: Subtraction test passed.");
	    }

	    @Test
	    public void testMultiplication() {
	        int product = 5 * 3;
	        Assert.assertEquals(product, 15, "Multiplication test failed");
	        System.out.println("Test 3: Multiplication test passed.");
	    }

	    @Test
	    public void testDivision() {
	        int quotient = 6 / 3;
	        Assert.assertEquals(quotient, 2, "Division test failed");
	        System.out.println("Test 4: Division test passed.");
	    }

	    @Test
	    public void testFail() {
	        Assert.fail("This test is intentionally failing.");
	    }
	}


