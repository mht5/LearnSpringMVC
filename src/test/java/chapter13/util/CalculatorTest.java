package chapter13.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import chapter13.util.Calculator;

public class CalculatorTest {
	Calculator calculator;
	
	@Before
	public void init() {
		calculator = new Calculator();
	}
	
	@After
	public void cleanUp() {}
	
	@Test
	public void testAdd() {
		int result = calculator.add(1, 2);
		Assert.assertEquals(3, result);
	}
	
	@Test
	public void testSubstract() {
		int result = calculator.substract(1, 2);
		Assert.assertEquals(-1, result);
	}
}
