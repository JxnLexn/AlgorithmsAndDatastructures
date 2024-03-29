package Scheinaufgaben.set04;

public class TaskDemo {

	public static void reorderTasks(TaskList tlist) {
		for (int i = 0; i < tlist.size() - 1; i++) {
			for (int j = i + 1; j < tlist.size(); j++) {
				if (tlist.getPriority(i).compareTo(tlist.getPriority(j)) > 0) {
					tlist.swap(i, j);
				}

			}
		}
	}

	/**
	 * generates a list of tasks with randomly chosen priority
	 */
	public static TaskList generateRandomList(int size) {
		TaskList m = new TaskList(size);
		for (int i = 0; i < size; i++) {
			double rnd = Math.random();
			if (rnd < 0.33) {
				m.add(new Task(Priority.LOW, "task_low_" + i));
			} else if (rnd < 0.66) {
				m.add(new Task(Priority.MEDIUM, "task_medium_" + i));
			} else {
				m.add(new Task(Priority.HIGH, "task_high_" + i));
			}
		}

		return m;
	}
	
	
	
	public static void main(String[] args) {
		demo01();
		System.out.println();
		
		demo02();
		System.out.println();
		
		runtimeMeasurement();
		
		System.out.println("- done -");

	}
	
	public static void demo01() {
		System.out.println("demo01: ");
		TaskList tl1 = new TaskList(100);
		tl1.add(new Task(Priority.MEDIUM, "Task1"));
		tl1.add(new Task(Priority.HIGH, "Task2"));
		tl1.add(new Task(Priority.LOW, "Task3"));
		tl1.add(new Task(Priority.LOW, "Task4"));
		tl1.add(new Task(Priority.HIGH, "Task5"));
		tl1.add(new Task(Priority.MEDIUM, "Task6"));

		tl1.swap(2, 4);
		tl1.print();
		System.out.println("? Correctly ordered: " + tl1.isOrdered());

		System.out.println("--- reorder:");

		reorderTasks(tl1);
		tl1.print();
		System.out.println("? Correctly ordered: " + tl1.isOrdered());
		System.out.println();
	}

	
	public static void demo02() {
		System.out.println("demo02: ");
		TaskList m2 = generateRandomList(50);
		System.out.println("? Correctly ordered: " + m2.isOrdered());

		System.out.println("--- reorder ---:");

		reorderTasks(m2);
		m2.print();
		System.out.println("? Correctly ordered: " + m2.isOrdered());	
	}

	public final static int MAX_ANZAHL = 10000000;

	public static void runtimeMeasurement() {
		System.out.println("Runtime: ");
		for (int count = 10; count <= MAX_ANZAHL; count *= 10) {
			runtimeMS(count);
			
		}
	}
	
	/** generates a random list of count tasks and measures the running time
	 *  required to reorder the list.
	 * @param count	   number of tasks in the list
	 * @return         runtime for reordering in milliseconds
	 */
	
	public static double runtimeMS(int count) {
		System.out.printf("n = %9d ...", count);
		TaskList tl = generateRandomList(count);
		System.out.print("(generated): ");
		long start = System.nanoTime();
		reorderTasks(tl);
		long end = System.nanoTime();
		
		double timeMS =  (end - start) / 1e6;
		System.out.printf(" %8.3f ms.%n", timeMS);
		return timeMS;
	}
	
	 
}
