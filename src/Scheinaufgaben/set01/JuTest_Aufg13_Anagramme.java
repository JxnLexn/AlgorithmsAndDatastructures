package Scheinaufgaben.set01;

//JUnit 5 (Jupiter)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//// JUnit 4
//import org.junit.Test;
//import org.junit.Before;
//import static org.junit.Assert.*;


public class JuTest_Aufg13_Anagramme {

	
	@Test
	public void testAnagrammeTrue() {
		assertTrue( Aufg13_Anagramme.areAnagrams("WIEN", "WEIN") );
		assertTrue( Aufg13_Anagramme.areAnagrams("LAMPE", "PALME") );
		assertTrue( Aufg13_Anagramme.areAnagrams("PERMUTATION", "TRAUMPOETIN") );
		assertTrue( Aufg13_Anagramme.areAnagrams("SCHUTZUMSCHLAG", "UMZUGSSCHLACHT") );
		assertTrue( Aufg13_Anagramme.areAnagrams("CORONAVIRUS", "CARNIVOROUS") );
	
	}		

	@Test
	public void testAnagrammeFalse() {
		assertFalse( Aufg13_Anagramme.areAnagrams("WIEN", "WEEN") );
		assertFalse( Aufg13_Anagramme.areAnagrams("LMPE", "PALME") );
		assertFalse( Aufg13_Anagramme.areAnagrams("PERMUTATION", "RRAUMPOETIX") );
		assertFalse( Aufg13_Anagramme.areAnagrams("SCHUTZUMSCHLAG", "UMZGSSSCHLACHT") );
		assertFalse( Aufg13_Anagramme.areAnagrams("CORONAVIRUSS", "CARNIVOURUUS") );
	
	}	
}
