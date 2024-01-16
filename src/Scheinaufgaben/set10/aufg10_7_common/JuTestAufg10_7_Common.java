package Scheinaufgaben.set10.aufg10_7_common;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class JuTestAufg10_7_Common {

	private String[] n0 = {};
	private String[] n1 = {"P1", "P2", "P3"};	// P1 - P3
	private String[] n2 = {"P3", "P2", "P3", "P1", "P4", "P2"}; //P1 - P4
	private String[] n3 = {"P5", "P2", "P3", "P1", "P4", "P2", }; //P1 - P5
	private String[] n4 = {"P0", "P4", "P2", "P6"}; // P0, P2, P4, P6
	
	public static final int LEN = 10000;

	
	@Test
	public void testCommonNames_0() {
		Set<String> cnames;
		cnames = Aufg10_7_Common.commonNames(n0,n0);
		assertEquals(0, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n0,n1);
		assertEquals(0, cnames.size());
		
	}

	@Test
	public void testCommonNames_1() {
		Set<String> cnames;
		cnames = Aufg10_7_Common.commonNames(n1,n0);
		assertEquals(0, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n1,n1);
		assertEquals(3, cnames.size());
		
		cnames = Aufg10_7_Common.commonNames(n1,n2);
		assertEquals(3, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n1,n3);
		assertEquals(3, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n1,n4);
		assertEquals(1, cnames.size());
	}


	
	@Test
	public void testCommonNames_2() {
		Set<String> cnames;
		cnames = Aufg10_7_Common.commonNames(n2,n0);
		assertEquals(0, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n2,n1);
		assertEquals(3, cnames.size());
		
		cnames = Aufg10_7_Common.commonNames(n2,n2);
		assertEquals(4, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n2,n3);
		assertEquals(4, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n2,n4);
		assertEquals(2, cnames.size());
	}
	
	
	@Test
	public void testCommonNames_3() {
		Set<String> cnames;
		cnames = Aufg10_7_Common.commonNames(n3,n0);
		assertEquals(0, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n3,n1);
		assertEquals(3, cnames.size());
		
		cnames = Aufg10_7_Common.commonNames(n3,n2);
		assertEquals(4, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n3,n3);
		assertEquals(5, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n3,n4);
		assertEquals(2, cnames.size());
	}
	
	@Test
	public void testCommonNames_4() {
		Set<String> cnames;
		cnames = Aufg10_7_Common.commonNames(n4,n0);
		assertEquals(0, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n4,n1);
		assertEquals(1, cnames.size());
		
		cnames = Aufg10_7_Common.commonNames(n4,n2);
		assertEquals(2, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n4,n3);
		assertEquals(2, cnames.size());

		cnames = Aufg10_7_Common.commonNames(n4,n4);
		assertEquals(4, cnames.size());
	}
	
	@Test
	public void testCommonNames_5() {
		Set<String> cnames;
		cnames = Aufg10_7_Common.commonNames(n2,n4);
		assertFalse( cnames.contains("P0"));
		assertFalse( cnames.contains("P1"));
		assertTrue( cnames.contains("P2"));
		assertFalse( cnames.contains("P3"));
		assertTrue( cnames.contains("P4"));
		assertFalse( cnames.contains("P5"));
	
	}
	
	
	@Test
	public void testCommonNamesLong() {
		// generate two long arrays, halve of the entries are common
		String[] a1 = new String[LEN];
		String[] a2 = new String[LEN];
		for (int i = 0; i < LEN; i++) {
			a1[i] = "N_" + i;
			a2[LEN-1-i] = "N_" + (2*i);
		}
		
		Set<String> cnames;
		cnames = Aufg10_7_Common.commonNames(a1,a2);
		assertEquals(LEN/2, cnames.size());
			
	}
}
