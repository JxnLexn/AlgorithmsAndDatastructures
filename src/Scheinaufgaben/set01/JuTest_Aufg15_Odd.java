package Scheinaufgaben.set01;


//JUnit 5 (Jupiter)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class JuTest_Aufg15_Odd {

		
	@Test
	public void testContainsOdd_1() {
		int[] a1 = { 3 };
		assertEquals(true, Aufg15_Odd.containsOdd(a1, 0));
	}
	
	@Test
	public void testContainsOdd_2() {
		int[] a1 = { 4 };
		assertEquals(false, Aufg15_Odd.containsOdd(a1, 0));
	}
		
	@Test
	public void testContainsOdd_3() {
		int[] a2 = { 2, 4, 5, 8, 11, 12 };
		assertFalse(Aufg15_Odd.containsOdd(a2, 0));
		assertFalse(Aufg15_Odd.containsOdd(a2, 1));
		assertTrue(Aufg15_Odd.containsOdd(a2, 2));
		assertTrue(Aufg15_Odd.containsOdd(a2, 3));
		assertTrue(Aufg15_Odd.containsOdd(a2, 4));
		assertTrue(Aufg15_Odd.containsOdd(a2, 5));
	}

	@Test
	public void testContainsOdd_4() {
		int[] a3 = { 0, 2, 4, 8, 12 };
		assertFalse(Aufg15_Odd.containsOdd(a3, 0));
		assertFalse(Aufg15_Odd.containsOdd(a3, 1));
		assertFalse(Aufg15_Odd.containsOdd(a3, 2));
		assertFalse(Aufg15_Odd.containsOdd(a3, 3));
		assertFalse(Aufg15_Odd.containsOdd(a3, 4));
	}


	@Test
	public void testAllOdd_0() {
		int[] arr0 = {  }; // array of length 0
		assertTrue(Aufg15_Odd.allOdd(arr0));
	}
	

	@Test
	public void testAllOdd_1() {
		int[] arr1 = { 4 };
		assertFalse(Aufg15_Odd.allOdd(arr1));
	}
	
	@Test
	public void testAllOdd_2() {
		int[] arr2 = { 13 };
		assertTrue(Aufg15_Odd.allOdd(arr2));
	}
	
	@Test
	public void testAllOdd_3() {
		int[] arr3 = { 21, 9, 3, 7, 5 };
		assertTrue(Aufg15_Odd.allOdd(arr3));
	}
	
	@Test
	public void testAllOdd_4() {
		int[] arr4 = { 3, 4, 5, 7, 9 };
		assertFalse(Aufg15_Odd.allOdd(arr4));
	}
	
	@Test
	public void testAllOdd_5() {
		int[] arr5 = { 2, 11, 5, 5 };
		assertFalse(Aufg15_Odd.allOdd(arr5));
	}
	
	@Test
	public void testAllOdd_6() {
		int[] arr6 = { 1, 3, 5, 7, 10};
		assertFalse(Aufg15_Odd.allOdd(arr6));
	}	
}
