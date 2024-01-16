package Scheinaufgaben.set11.aufg11_1_iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements a FIFO queue with bounded capacity as a ring buffer
 */
public class ArrayQueue<E> implements Iterable<E> {
	private E[] buffer;


	private int inIndex; // position where to insert next entry
	private int outIndex; // position of next entry to be dequeued
	private int count; // number of stored entries

	public ArrayQueue(int capacity) {
		buffer = (E[]) new Object[capacity];
		inIndex = 0;
		outIndex = 0;
		count = 0;
	}

	public void enqueue(E elem) throws QueueError {
		if (count < buffer.length) {
			buffer[inIndex] = elem;
			inIndex = (inIndex + 1) % buffer.length;
			count++;
		} else
			throw new QueueError("enqueue: Buffer full!");
	}

	public E dequeue() throws QueueError {
		if (count > 0) {
			E elem = buffer[outIndex];
			outIndex = (outIndex + 1) % buffer.length;
			count--;
			return elem;
		} else
			throw new QueueError("dequeue: Buffer empty!");

	}

	private class QueueIterator implements Iterator<E> {
		private int currentIndex = outIndex;
		private int remaining = count;

		@Override
		public boolean hasNext() {
			return remaining > 0;
		}

		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E item = buffer[currentIndex];
			currentIndex = (currentIndex + 1) % buffer.length;
			remaining--;
			return item;
		}
	}


	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return (count == buffer.length);
	}

	public int size() {
		return count;
	}

}
