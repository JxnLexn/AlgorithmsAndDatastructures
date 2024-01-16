package Scheinaufgaben.set01;

import java.util.Arrays;

public class Aufg15_Odd {

	/** 
	 * Checks if an odd value is contained in arr[0..endIndex]
	 * linear recursive version
	 */
	public static boolean containsOdd(int[] arr, int endIndex) {
		if (endIndex < 0) {
			return false;
		}

		if (arr[endIndex] % 2 != 0) {
			return true;
		}

		return containsOdd(arr, endIndex - 1);
	}


	/** 
	 * checks if all values contained in array arr are odd numbers
	 */
	public static boolean allOdd(int[] arr) {
		return allOddRecursive(arr, arr.length - 1);
	}

	private static boolean allOddRecursive(int[] arr, int endIndex) {
		if (endIndex < 0) {
			return true;
		}

		if (arr[endIndex] % 2 == 0) {
			return false;
		}

		return allOddRecursive(arr, endIndex - 1);
	}
	
	public static void main(String[] args) {
		System.out.println("containsOdd:");
		int[] arr1 = { 2, 4, 5, 8 };
		System.out.println("arr1: " + Arrays.toString(arr1));
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(i + ": " + containsOdd(arr1, i));
		}

		System.out.println();
		int[] arr2 = { 1, 3, 7, 5, 9 };
		System.out.println("arr2: " + Arrays.toString(arr2));
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(i + ": " + containsOdd(arr2, i));
		}

		System.out.println();

		System.out.println("allOdd(arr1):" + allOdd(arr1));
		System.out.println("allOdd(arr2):" + allOdd(arr2));

	}


}
