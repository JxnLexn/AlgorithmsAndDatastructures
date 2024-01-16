package Scheinaufgaben.set07.aufg7_3_prioqueue;

import java.util.Random;

public class HeapQueueDemo {

	private final static Random rand = new Random();

	/** Heapbasierte Priorit�tenwarteschlange testen */
	public static void main(String[] args) {
		final int ANZAHL = 10;
		ITaskQueue heapQueue = new HeapTaskQueue(2*ANZAHL);
		demoPrioQueue_1();
		System.out.println();
		demoPrioQueue_2(heapQueue, ANZAHL);
	}
	

	public static void demoPrioQueue_1() {
		ITaskQueue taskQueue = new HeapTaskQueue(10);
		
		taskQueue.insert(new Task("T7", 7));
		taskQueue.insert(new Task("T8", 8));
		taskQueue.insert(new Task("T2", 2));
		taskQueue.insert(new Task("T4", 4));
		taskQueue.insert(new Task("T5", 5));
		
		System.out.println(taskQueue.extractMin()); // -> T2
		System.out.println(taskQueue.extractMin()); // -> T4
		
		System.out.println();
		
		taskQueue.insert(new Task("T1", 1));
		taskQueue.insert(new Task("T6", 6));
		taskQueue.insert(new Task("T3", 3));
		
		while (!taskQueue.isEmpty()) {
			System.out.println(taskQueue.extractMin()); // -> T1, T3, T5, T6, T7, T8
		}
		
	}
	
	
	/** Test f�r die Funktionsweise einer Priorit�tenwarteschlange 
	 *  (1) erst n Elemente mit insert einf�gen, (2) dann 100 mal insert/extractMin,
	 *  (3) dann alle n Elemente mit extractMin entfernen 
	 */
	public static void demoPrioQueue_2(ITaskQueue prioQueue, int ANZAHL) {
		//zuf�llig gew�hlte Eintr�ge in der Warteschlange ablegen 
		System.out.println(ANZAHL + " Zufallswerte einf�gen");
		for (int i = 0; i < ANZAHL; i++) {
			Task neu = randEintrag(1000);
			System.out.println("insert: " + neu);			
			prioQueue.insert(neu);
		}		
		System.out.println();
		
		//ANZAHL/2 viele Eintr�g entfernen (d.h. mit den kleinsten Priorit�tswerten)
		System.out.println("Die " + (ANZAHL/2) + " kleinsten Werte entnehmen:");
		for (int i = 0; i < ANZAHL/2; i++) {
			Task eintrag = prioQueue.extractMin();
			System.out.println("entfernt: " + eintrag);
		}
		System.out.println();
		
		//nochmals ANZAHL viele Eintr�ge ablegen
		System.out.println("Nochmals " + ANZAHL + " Zufallswerte einf�gen");
		for (int i = ANZAHL; i < 2*ANZAHL; i++) {
			Task neu = randEintrag(1000);
			System.out.println("insert: " + neu);			
			prioQueue.insert(neu);
		}		
		System.out.println();
		
		//Alle Eintr�ge aus der Warteschlange entfernen
		System.out.println("Alle Werte entfernen (sollte aufsteigend sortiert sein!)");		
		while(! prioQueue.isEmpty()) {
			Task eintrag = prioQueue.extractMin();
			System.out.println("entfernt: " + eintrag);			
		}
	}

	public static Task randEintrag(int maxValue) {
		int prio = rand.nextInt(maxValue); 
		return new Task("Task_"+prio, prio);
	}
	
	
}
