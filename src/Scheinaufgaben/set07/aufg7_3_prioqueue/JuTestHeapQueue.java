package Scheinaufgaben.set07.aufg7_3_prioqueue;

//JUnit 5 (Jupiter)

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class JuTestHeapQueue {
 
	public static int ANZAHL = 100;
	
	@Test
	public void test01EmptyFull() {
		ITaskQueue prioQueue = new HeapTaskQueue(ANZAHL);
		 
		//Priorit�tenwarteschlange am Anfang leer
		assertTrue(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());
		
		//Eintr�ge einf�gen ==> nicht mehr leer
		prioQueue.insert(new Task("Task_X", 4));
		assertFalse(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());

		//noch einen Eintrag einf�gen ==> nicht leer
		prioQueue.insert(new Task("Task_Y", 3));
		assertFalse(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());
		
		//einen Eintrag entfernen ==> noch nicht leer
		prioQueue.extractMin();
		assertFalse(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());
		
		//Eintrag einf�gen ==> 
		prioQueue.insert(new Task("Task_Z", 1));
		assertFalse(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());

		//einen Eintrag entfernen ==> noch nicht leer
		prioQueue.extractMin();
		assertFalse(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());
		
		//noch einen Eintrag entfernen ==> jezt wieder leer
		prioQueue.extractMin();
		assertTrue(prioQueue.isEmpty());
		assertFalse(prioQueue.isFull());

	}

	
	@Test
	public void test02insertExtractMin() {
		ITaskQueue prioQueue = new HeapTaskQueue(ANZAHL);

		Task e1a = new Task("E1a", 1);
		Task e1b = new Task("E1b", 1);
		Task e2a = new Task("E2a", 2);
		Task e2b = new Task("E2b", 2);
		Task e3 = new Task("E3", 3);
		Task e4 = new Task("E4", 4);
		Task e5 = new Task("E5", 5);
		Task e6 = new Task("E6", 6);
		
		//einige Werte eintragen
		prioQueue.insert(e3);
		prioQueue.insert(e2a);
		prioQueue.insert(e5);
		prioQueue.insert(e1a);
		prioQueue.insert(e2b);
		
		//Inhalt jetzt: {e1a, e2a, e2b,e3, e5}
		
		//Wert entfernen, sollte Priorit�t 1 haben
		Task emin = prioQueue.extractMin();
		assertEquals(1, emin.getPrio());
		
		//Inhalt jetzt: {e2a, e2b,e3, e5}
		
		//Wert entfernen, sollte Priorit�t 2 haben
		emin = prioQueue.extractMin();
		assertEquals(2, emin.getPrio());
				
		//Inhalt jetzt: {e2b,e3, e5}
		
		//Werte einf�gen
		prioQueue.insert(e4);
		prioQueue.insert(e1b);
		
		//Inhalt jetzt: {e1b, e2b, e3, e4, e5}
		
		//Wert entfernen, sollte Priorit�t 1 haben
		emin = prioQueue.extractMin();
		assertEquals(1, emin.getPrio());
		
		//Wert entfernen, sollte Priorit�t 2 haben
		emin = prioQueue.extractMin();
		assertEquals(2, emin.getPrio());
		
		//Wert entfernen, sollte Priorit�t 3 haben
		emin = prioQueue.extractMin();
		assertEquals(3, emin.getPrio());
		
		//Inhalt jetzt: {e4, e5}
		
		//Werte einf�gen
		prioQueue.insert(e6);

		//Inhalt jetzt: {e4, e5, e6}

		
		//Wert entfernen, sollte Priorit�t 4 haben
		emin = prioQueue.extractMin();
		assertEquals(4, emin.getPrio());

		//Wert entfernen, sollte Priorit�t 5 haben
		emin = prioQueue.extractMin();
		assertEquals(5, emin.getPrio());


		//Wert entfernen, sollte Priorit�t 6 haben
		emin = prioQueue.extractMin();
		assertEquals(6, emin.getPrio());

		//Warteschlange sollte jetzt leer sein
		assertTrue(prioQueue.isEmpty());	
	}
	
	
	@Test
	public void test03Random() {
		ITaskQueue prioQueue = new HeapTaskQueue(ANZAHL);

		//Task mit zuf�llig gew�hlter Priorit�t in der Warteschlange ablegen 
		for (int i = 0; i < ANZAHL; i++) {
			Task neu = randEintrag(1000);
			prioQueue.insert(neu);
		}		

		assertTrue(prioQueue.isFull());
		
		// Alle Eintr�ge entfernen, m�ssen nach Priorit�t geordnet sein
		Task current = prioQueue.extractMin();
		Task previous;
		int count = 1;
		while (! prioQueue.isEmpty()) {
			previous = current;
			Task next = prioQueue.extractMin();
			assertTrue(next.getPrio() >= previous.getPrio());
			count++;
		}
		assertEquals(ANZAHL, count);
	
	}

	public static Random rand = new Random();
	
	public static Task randEintrag(int maxValue) {
		int prio = rand.nextInt(maxValue); 
		return new Task("Task_"+prio, prio);
	}
	
}
