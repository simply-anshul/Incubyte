import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTesting {

	@Test
	void test1_1() {
		//Empty String test case
		assertEquals(0, StringCalculator.Add(""));
	}
	
	@Test
	void test1_2() {
		//Single element and 2 element string test case
		assertEquals(1, StringCalculator.Add("1"));
		assertEquals(2, StringCalculator.Add("2"));
		assertEquals(3, StringCalculator.Add("1,2"));
		assertEquals(5, StringCalculator.Add("2,3"));
	}

	@Test
	void test2() {
		//Unknown number of elements
		assertEquals(6, StringCalculator.Add("1,2,3"));
	}
	
	@Test
	void test3() {
		//Handle new lines
		//assertEquals(6, StringCalculator.Add("1\n2,3"));
		assertEquals(10, StringCalculator.Add("1,2\n3,4"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
