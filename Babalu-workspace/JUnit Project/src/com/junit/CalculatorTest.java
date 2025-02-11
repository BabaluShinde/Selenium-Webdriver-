package com.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class Calculator{
	int add(int a, int b) {
		return a+b;
		
	}
}
public class CalculatorTest {
	
	private Calculator calculator;
	
	@BeforeEach
	void Setup() {
		calculator = new Calculator();
	}
	
	@Test
	void Testaddition() {
		int result=calculator.add(3,7);
		assertEquals(10,result,"This is checked that the expected and actual are equals.");
	}

}
