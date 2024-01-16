package Scheinaufgaben.set07.aufg7_3_prioqueue;

/** Implementierung einer Priorit�tenwarteschlange mit beschr�nkter Kapazit�t als sortiertes Feld 
 *  Die Eintr�ge sind absteigend nach Zahlenwert f�r die Priorit�t sortiert.
 *  
 * @author schied
 *
 * @param <E>
 */
public class SortedPrioQueue implements ITaskQueue{
	/** Array f�r die Eintr�ge */
	private Task[] arr;
	
	/** aktuelle Anzahl der Eintr�ge im Array arr */
	private int count = 0;
		
	/** erzeugt eine Warteschlange mit der angegebenen Maximalkapazit�t
	 * 
	 * @param maxSize maximale Anzahl der speicherbaren Eintr�ge
	 */
	public SortedPrioQueue(int maxSize) {
		arr = new Task[maxSize];
	}
	
	/** F�gt einen neuen Eintrag in die Warteschlange ein.
	 *  @precondition Die Warteschlange ist nicht voll
	 */
	@Override
	public void insert(Task e) {
		int pos = count;
		while (pos > 0 && arr[pos-1].getPrio() < e.getPrio()) {
			arr[pos] = arr[pos - 1];
			pos--;
		}
		arr[pos] = e;
		count++;
	}

	/** entfernt den Eintrag mit der h�chsten Priorit�t (kleinster int-Wert)
	 *  aus der Warteschlange und gibt ihn zur�ck
	 */
	@Override
	public Task extractMin() {
		Task minEintrag = arr[count-1];
		arr[count-1] = null;
		count--;
		return minEintrag;
	}

	/** pr�ft, ob die Warteschlange leer ist
	 */
	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	/** pr�ft, ob die Warteschlange voll ist
	 */
	@Override
	public boolean isFull() {
		return (count == arr.length);
	}

}
