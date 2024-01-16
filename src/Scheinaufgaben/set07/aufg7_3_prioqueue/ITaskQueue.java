package Scheinaufgaben.set07.aufg7_3_prioqueue;

public interface ITaskQueue {
	/**
	 * Task (mit Beschreibung und Priorit�t) in die Priorit�tenwarteschlange aufnehmen
	 */
	void insert(Task e);

	/**
	 * Den Task mit der h�chsten Priorit�t (= kleinster Wert f�r Priorit�t) aus
	 * der Warteschlange entnehmen
	 *
	 * @return entnommener Eintrag (bzw. null, wenn Warteschlange leer
	 */
	Task extractMin();

	/** Pr�ft, ob Warteschlange leer ist */
	boolean isEmpty();

	/** Pr�ft, ob Warteschlange voll ist */
	boolean isFull();
}
