package Scheinaufgaben.set10.aufg10_7_common;

import java.util.*;

public class Aufg10_7_Common {


	
	/**
	 * Computes the set of all names that are contained both in a1 and in a2.
	 */
	public static Set<String> commonNames(String[] names1, String[] names2) {
		return commonNames1_hashset(names1, names2);
//		return commonNames2_treeset(names1, names2);
			
	}

	public static Set<String> commonNames1_hashset(String[] names1, String[] names2) {
		Set<String> set1 = new HashSet<>(Arrays.asList(names1));
		Set<String> common = new HashSet<>();
		for (String name : names2) {
			if (set1.contains(name)) {
				common.add(name);
			}
		}
		return common;
	}


	public static Set<String> commonNames2_treeset(String[] names1, String[] names2) {
		Set<String> set1 = new TreeSet<>(Arrays.asList(names1));
		Set<String> common = new TreeSet<>();
		for (String name : names2) {
			if (set1.contains(name)) {
				common.add(name);
			}
		}
		return common;
	}




	public static final int MAX_LEN = 1000000;

	public static void main(String[] args) {
		demo01();
		measureRuntime(MAX_LEN);
	}

	private static void demo01() {
		String[] n1 = { "P1", "P2", "P5", "P2" };
		String[] n2 = { "P4", "P3", "P2", "P1", "P8", "P7", "P6", "P5", "P1", "P3" };
		String[] n3 = { "P2", "P1", "P5", "P7", "P9" };

		Set<String> result12 = commonNames(n1, n2);
		System.out.print("n1 <-> n2: ");
		for (String v : result12) {
			System.out.print(v + " ");
		}
		System.out.println();

		Set<String> result13 = commonNames(n1, n3);
		System.out.print("n1 <-> n3: ");
		for (String v : result13) {
			System.out.print(v + " ");
		}
		System.out.println();

		Set<String> result23 = commonNames(n2, n3);
		System.out.print("n2 <-> n3: ");
		for (String v : result23) {
			System.out.print(v + " ");
		}
		System.out.println();

	}

	/** 
	 * 
	 * @param maxLen
	 */
	private static void measureRuntime(int maxLen) {
		for (int len = 10; len <= maxLen; len *= 10) {
			// fill two arrays of length len, 
			// halve of the values are the same
			String[] names1 = new String[len];
			String[] names2 = new String[len];
			for (int i = 0; i < len; i++) {
				names1[i] = "Name_" + i;
				names2[i] = "Name_" + (i + len/2);
			}
		
			// shuffle entries of arrays
			shuffle(names1);
			shuffle(names2);

			System.out.printf("len = %8d:", len);
			long start = System.nanoTime();
			// compute set of common names of both arrays
			Set<String> result = commonNames(names1, names2);
			long ende = System.nanoTime();
			
			System.out.printf(" common names: %6d, runtime %8.2f ms%n", result.size(), (ende - start) / 1e6);
		}
		System.out.println("- finished -");
	}

	/** shuffles randomly the entries of array arr
	 * */
	public static <E> void shuffle(E[] arr) {
		Random rand = new Random();
		for (int i = 1; i < arr.length; i++) {
			int pos = rand.nextInt(i);
			// swap arr[pos] and arr[i]
			E tmp = arr[pos];
			arr[pos] = arr[i];
			arr[i] = tmp;
		}
	}

	public static void demoShuffle() {
		String[] arr = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		shuffle(arr);
		for (String n : arr) {
			System.out.print(n + "  ");
		}
		System.out.println();

	}
}
