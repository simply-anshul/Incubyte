import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTesting {

	@Test
	void test1_1() throws Exception {
		//Empty String test case
		assertEquals(0, StringCalculator.Add(""));
	}
	
	@Test
	void test1_2() throws Exception {
		//Single element and 2 element string test case
		assertEquals(1, StringCalculator.Add("1"));
		assertEquals(2, StringCalculator.Add("2"));
		assertEquals(3, StringCalculator.Add("1,2"));
		assertEquals(5, StringCalculator.Add("2,3"));
	}

	@Test
	void test2() throws Exception {
		//Unknown number of elements
		assertEquals(6, StringCalculator.Add("1,2,3"));
		assertEquals(10, StringCalculator.Add("1,2,3,4"));
		assertEquals(14, StringCalculator.Add("2,3,4,5"));
		assertEquals(42, StringCalculator.Add("2,4,6,8,10,12"));
	}
	
	@Test
	void test3() throws Exception {
		//Handle new lines between numbers
		assertEquals(6, StringCalculator.Add("1\n2,3"));
		assertEquals(10, StringCalculator.Add("1,2\n3,4"));
		assertEquals(10, StringCalculator.Add("1,2,3\n4"));
		assertEquals(14, StringCalculator.Add("2\n3,4,5"));		
	}
	
	@Test
	void test4() throws Exception {
		//Support Different Delimiters
		assertEquals(3, StringCalculator.Add("//;\n1;2"));
		assertEquals(6, StringCalculator.Add("//:\n1:2:3"));
		assertEquals(10, StringCalculator.Add("//'\n1'2'3'4"));
		assertEquals(3, StringCalculator.Add("// \n1 2"));
	}
	
	@Test 
	void test5() throws Exception{
		//Handling Negative values
		assertEquals(1, StringCalculator.Add("1,-2"));
		assertEquals(1, StringCalculator.Add("1,-2,-3"));
	}
	
	@Test 
	void test6() throws Exception{
		//Handling Negative values
		assertEquals(0, StringCalculator.Add("-1,-2"));
		assertEquals(1, StringCalculator.Add("1,-2,-3"));
	}
		
}
