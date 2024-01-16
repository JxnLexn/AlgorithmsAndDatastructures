package Scheinaufgaben.set07.aufg7_3_prioqueue;

public class HeapTaskQueue implements ITaskQueue{
	private Task[] heap;
	private int size;

	public HeapTaskQueue(int capacity) {
		heap = new Task[capacity];
		size = 0;
	}

	@Override
	public void insert(Task e) {
		if (isFull()) {
			throw new IllegalStateException("Queue is full");
		}
		heap[size] = e;
		siftUp(size);
		size++;
	}

	@Override
	public Task extractMin() {
		if (isEmpty()) {
			return null;
		}
		Task min = heap[0];
		heap[0] = heap[--size];
		heap[size] = null;
		siftDown(0);
		return min;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean isFull() {
		return size == heap.length;
	}

	private void siftUp(int index) {
		Task temp = heap[index];
		while (index > 0) {
			int parentIndex = (index - 1) / 2;
			Task parent = heap[parentIndex];
			if (temp.getPrio() >= parent.getPrio()) {
				break;
			}
			heap[index] = parent;
			index = parentIndex;
		}
		heap[index] = temp;
	}

	private void siftDown(int index) {
		Task temp = heap[index];
		int child;
		while (2 * index + 1 < size) {
			int leftChild = 2 * index + 1;
			int rightChild = 2 * index + 2;
			if (rightChild < size && heap[rightChild].getPrio() < heap[leftChild].getPrio()) {
				child = rightChild;
			} else {
				child = leftChild;
			}
			if (temp.getPrio() <= heap[child].getPrio()) {
				break;
			}
			heap[index] = heap[child];
			index = child;
		}
		heap[index] = temp;
	}
}
