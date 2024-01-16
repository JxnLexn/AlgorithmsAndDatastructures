package Scheinaufgaben.set01;

import javax.swing.*;
import java.util.Random;

public class Aufg13_Anagramme {

	private static Random rand = new Random();

	public static boolean areAnagrams(String s1, String s2) {

		int[] value = new int[256];

		for (int i = 0; i < s1.length(); i++) {
			value[s1.charAt(i)]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			value[s2.charAt(i)]--;


			if (value[s2.charAt(i)] < 0) {
				return false;
			}
		}

		for (int i = 0; i < 256; i++) {
			if (value[i] != 0) {
				return false;
			}
		}

		return true;
	}




	/**
	 * Führt Tests und Laufzeitmessungen für die Anagrammprüfung durch
	 * 
	 */
	public static void main(String[] args) {
		simpleTests();
		
		String eingabe = JOptionPane.showInputDialog("maximale Länge für Anagrammtest:");
		if (eingabe == null) {
			System.out.println("Abgebrochen!");
			return;
		}
		int laenge = Integer.parseInt(eingabe);
		
		System.out.println("Anagramme: "); 
		for (int len = 100; len <= laenge; len *= 10) {
			String[] anas = erzeugeAnagramme(len);
			boolean result = measureAnagrams(anas[0], anas[1]);
			if (result == false) {
				throw new RuntimeException("Falsches Ergebnis beim Anagrammtest!");
			} else {
				System.out.println("O.K.");
			}

			System.out.println();
		}
		
		System.out.println();
		System.out.println("KEINE Anagramme:");
		for (int len = 100; len <= laenge; len *= 10) {
			String[] nonAnas = erzeugeNonAnagramme(len);
			boolean result = measureAnagrams(nonAnas[0], nonAnas[1]);
			if (result == true) {
				throw new RuntimeException("Falsches Ergebnis beim Anagrammtest!");
			} else {
				System.out.println("O.K.");
			}

			System.out.println();
		}
		
		System.out.println("fertig!");
	}

	
	
	/** Erzeugt einen String der angegebenen Länge aus zufällig gewählten Zeichen zwischen 'A' und 'z'
	 */
	public static String erzeugeRandomString(int laenge) {
		//Zeichenkette aus zufälligen Zeichen erzeugen
		StringBuilder sb1 = new StringBuilder(laenge);
		for (int i = 0; i < laenge; i++) {
			char ch = (char) (rand.nextInt('z'-'A') + 'A');
			sb1.append(ch);
		}
		return sb1.toString();
	}
	
	/** Erzeugt zwei Strings der angegebenen Länge, die Anagramme sind */
	public static String[] erzeugeAnagramme(int laenge) {
		String s1 = erzeugeRandomString(laenge);

		//Permutation von s1 erzeugen
		
		//Zunächst Kopie erzeugen
		StringBuilder sb2 = new StringBuilder(s1);
		for (int j = 0; j <= laenge / 4; j++) {
			//Zeichen an zwei zufällig gewählten Positionen
			//vertauschen
			int pos1 = rand.nextInt(laenge);
			int pos2 = rand.nextInt(laenge);
			char tmp1 = sb2.charAt(pos1);
			char tmp2 = sb2.charAt(pos2);
			sb2.setCharAt(pos1, tmp2);
			sb2.setCharAt(pos2, tmp1);
		}
	
		//beide Zeichenketten als Feld von zwei Strings zurück geben
		String s2 = sb2.toString();
		return new String[]{s1,s2};  //Feld mit s1 und s2 als Elementen zurückgeben
		
	}
	
	/** Erzeugt zwei Strings der angegebenen Länge, die keine Anagramme sind */
	public static String[] erzeugeNonAnagramme(int laenge) {
		String s1 = erzeugeRandomString(laenge);
		
		//Zunächst von s1 Kopie erzeugen
		StringBuilder sb2 = new StringBuilder(s1);
			
		//letztes Zeichen ver�ndern
		int pos = sb2.length() - 1;
		if (sb2.charAt(pos) == 'X') {
			sb2.setCharAt(pos, 'a');
		} 
		else {
			sb2.setCharAt(pos, 'X');
		}
		
		//beide Zeichenketten als Feld von zwei Strings zur�ck geben
		String s2 = sb2.toString();
		return new String[]{s1,s2};  //Feld mit s1 und s2 als Elementen zur�ckgeben
		
	}
	
	
	/** Prüft, ob beide Strings s1 und s2 Anagramme sind und misst die Laufzeit fü0r den Test */
	private static boolean measureAnagrams(String s1, String s2) {
		System.out.println("Länge s1: " + s1.length());
		System.out.println("Länge s2: " + s2.length());
		
		long tStart = System.nanoTime();
		
		boolean res = areAnagrams(s1, s2);
		long tEnd = System.nanoTime();
		
		System.out.println("sind Anagramme?: " + res);
		
		System.out.println("Laufzeit: " + (tEnd - tStart)/1e6 + " msec.");
		return res;
	}
	
	
	/** einige einfache Tests für Anagramme */
	private static void simpleTests() {
		System.out.println("LAMPE/PALME: " + areAnagrams("LAMPE", "PALME"));
		System.out.println("WIEN/WEIN: " + areAnagrams("WIEN","WEIN"));
		System.out.println("CORONAVIRUS/CARNIVOROUS: " + areAnagrams("CORONAVIRUS","CARNIVOROUS"));
		System.out.println("SCHUTZUMSCHLAG/UMZUGSSCHLACHT: " + areAnagrams("SCHUTZUMSCHLAG","UMZUGSSCHLACHT"));	
	}
}
