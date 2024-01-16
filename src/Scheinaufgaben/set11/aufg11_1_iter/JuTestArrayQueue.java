package Scheinaufgaben.set11.aufg11_1_iter;

/** JUnit test cases for class SearchTree
 * 
 */

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


public class JuTestArrayQueue {
	
	@Test public void testSimple() throws QueueError {
		ArrayQueue<Integer> buffer = new ArrayQueue<>(10);
		
		// initial buffer is empty
		assertTrue(buffer.isEmpty());
		
		// insert values from 1 to 10
		for (int i = 1; i <= 10; i++) {
			buffer.enqueue(i);
		}

		// buffer is full now
		assertTrue(buffer.isFull());
		assertEquals(10, buffer.size());
		
		// remove all 10 values, offered in order 1 to 10.
		for (int i = 1; i <= 10; i++) {
			int v = buffer.dequeue();
			assertEquals(i, v);
		}
		
		// buffer should be empty now
		assertTrue(buffer.isEmpty());
		
	}

	@Test public void testIterator() throws QueueError {
		ArrayQueue<Integer> buffer = new ArrayQueue<>(10);

		// insert values 1 to 8
		for (int i = 1; i <= 8; i++) {
			buffer.enqueue(i);
		}
		
		// iterator gives values from 1 to 8
		Iterator<Integer> iter = buffer.iterator();
		int expected = 1;
		while(iter.hasNext()) {
			int value = iter.next();
			assertEquals(expected, value);
			expected++;
		}
		
		// insert values 9 and 10
		buffer.enqueue(9);
		buffer.enqueue(10);
		
		iter = buffer.iterator();
		// iterator gives values from 1 to 10
		expected = 1;
		while(iter.hasNext()) {
			int value = iter.next();
			assertEquals(expected, value);
			expected++;
		}
		
		assertEquals(11, expected);
		
	}
	

}
