package Scheinaufgaben.set07.aufg7_3_prioqueue;

/** Klasse f�r einen einzelnen Eintrag in einer Priorit�tenwarteschlange.
 *  Jeder Eintrag besteht aus einem Wert (String) und einer ganzzahligen Priorit�t.
 *  
 */
public class Task {
	/** Beschreibung der Task */
	private String description;
	
	/** Priorit�t der Task, kleinerer Wert bedeutet h�here Priorit�t. */
	private int prio;
	
	/** Initialisiere eine neue Task mit Beschreibung und Priorit�t 
	 */
	public Task(String description, int prio) {
		this.description = description;
		this.prio = prio;
	}
	
	/** liefert die Beschreibung der Task */
	public String getDescription() {
		return description;
	}

	/** liefert die Priorit�t der Task */
	public int getPrio() {
		return prio;
	}
	
	/** liefert eine Zeichenkettendarstellung der Task */
	public String toString() {
		return "prio " + prio + ": " + description; 
	}
}
