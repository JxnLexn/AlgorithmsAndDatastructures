package Scheinaufgaben.set02;

import java.util.Set;

public class Aufg2_1_Brackets {

	/** generates all correctly nested sequences of round brackets
	 *  that can be build from n pair of brackets.*/
	public static Set<String> nestedBrackets(int n) {
		//TODO
		//TODO
		//TODO
		//TODO
		return null; 		//TODO

	}
	
	
	public static void main(String[] args) {
		Set<String> res = nestedBrackets(3);
		int count = 0;
		for (String s : res) {
			count++;
			System.out.println(count + ": " + s);
		}

	}
}
