import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTesting {
	StringCalculator C = new StringCalculator();

	@Test
	void test1_1() throws Exception {
		//Empty String test case
		assertEquals(0, C.Add(""));
	}
	
	@Test
	void test1_2() throws Exception {
		//Single element and 2 element string test case
		assertEquals(1, C.Add("1"));
		assertEquals(2, C.Add("2"));
		assertEquals(3, C.Add("1,2"));
		assertEquals(5, C.Add("2,3"));
	}

	@Test
	void test2() throws Exception {
		//Unknown number of elements
		assertEquals(6, C.Add("1,2,3"));
		assertEquals(10, C.Add("1,2,3,4"));
		assertEquals(14, C.Add("2,3,4,5"));
		assertEquals(42, C.Add("2,4,6,8,10,12"));
	}
	
	@Test
	void test3() throws Exception {
		//Handle new lines between numbers
		assertEquals(6, C.Add("1\n2,3"));
		assertEquals(10, C.Add("1,2\n3,4"));
		assertEquals(10, C.Add("1,2,3\n4"));
		assertEquals(14, C.Add("2\n3,4,5"));		
	}
	
	@Test
	void test4() throws Exception {
		//Support Different Delimiters
		assertEquals(3, C.Add("//;\n1;2"));
//		assertEquals(6, C.Add("//:\n1:2:3"));
//		assertEquals(10, C.Add("//'\n1'2'3'4"));
//		assertEquals(3, C.Add("// \n1 2"));
	}
	
	@Test 
	void test5() throws Exception{
		//Handling Negative values
		assertEquals(1, C.Add("1,-2"));
		assertEquals(1, C.Add("1,-2,-3"));
	}
	
	@Test 
	void test6() throws Exception{
		//Handling multiple Negative values
		assertEquals(0, C.Add("-1,-2"));
		assertEquals(1, C.Add("1,-2,-3"));
	}
	

    @Test
    void test7() throws Exception{
        assertEquals(0, C.calculateCount());
//        C.Add("12");
//        assertEquals(1, C.calculateCount());
    }

	@Test 
	void test8() throws Exception{
		//Handling numbers greater than 1000
		assertEquals(1, C.Add("1,1001"));
		assertEquals(1, C.Add("1,-2,5050"));
		assertEquals(3, C.Add("1,1001,2,2000"));
		assertEquals(0, C.Add("9000"));
	}
	
	@Test
	void test10() throws Exception {
		//Support Different Delimiters
		assertEquals(6, C.Add("//[***]\n1***2***3"));
	}
		
}
