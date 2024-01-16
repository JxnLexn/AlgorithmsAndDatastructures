package Scheinaufgaben.set02;

import java.util.Set;
import java.util.TreeSet;

public class Aufg2_2_Palindroms {

	/** Erzeugt die Menge aller Palindrome der Länge length, die mit den durch chSet
	 * gegebenen Zeichen gebildet werden können
	 */
	public static TreeSet<String> palindroms(int length, char[] chSet) {
		TreeSet<String> result = new TreeSet<>();

		if (length == 0) {
			result.add("");
			return result;
		}
		if (length == 1) {
			for (char c : chSet) {
				result.add(String.valueOf(c));
			}
			return result;
		}

		// Rekursion
		TreeSet<String> smallerPalindroms = palindroms(length - 2, chSet);
		for (String pal : smallerPalindroms) {
			for (char c : chSet) {
				result.add(c + pal + c);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		demo1();
		demo2();
	}

	private static void demo1() {
		char[] chSet1 = { 'a', 'b' };

		for (int length = 0; length <= 6; length++) {
			System.out.println("chSet1, Palindroms of length " + length + ":");
			Set<String> palindroms = palindroms(length, chSet1);
			for (String p : palindroms) {
				System.out.println("'" + p + "'");
			}
			System.out.println();
		}
	}

	private static void demo2() {
		char[] chSet2 = { '1', '2', '3', '4' };

		System.out.println("chSet2: Palindroms of length 3:");
		Set<String> palindroms = palindroms(4, chSet2);
		for (String p : palindroms) {
			System.out.println("'" + p + "'");
		}
		System.out.println();
	}
}
