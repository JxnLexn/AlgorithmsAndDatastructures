package Scheinaufgaben.set11.aufg11_1_iter;

public class QueueIterDemo {
	public static void main(String[] args) {
		ArrayQueue<String> queue = new ArrayQueue<>(4);
		try {
			queue.enqueue("Apple");
			queue.enqueue("Banana");
			queue.enqueue("Cherry");
			queue.enqueue("Date");

			System.out.println("Ausgabe mit Iterator:");
			for (String fruit : queue) {
				System.out.println(fruit);
			}

			System.out.println();
			System.out.println("Ausgabe mit ausgeführtem dequeue():");
			queue.dequeue();
			queue.dequeue();
			queue.enqueue("Strawberry");
			queue.enqueue("Raspberry");

			for (String fruit : queue) {
				System.out.println(fruit);
			}

			System.out.println();
			System.out.println("Ausgabe mit forEach-Schleife:");

			queue.forEach(System.out::println);

		} catch (QueueError e) {
			e.printStackTrace();
		}
	}
}
