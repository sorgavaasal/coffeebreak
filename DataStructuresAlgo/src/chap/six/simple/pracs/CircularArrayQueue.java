package chap.six.simple.pracs;

import java.lang.reflect.Array;

public class CircularArrayQueue<T> implements Queue<T> {
	
	private static final Integer staticSize = 8;
	private Integer headIndex = -1;
	private Integer tailIndex = 0;
	private T[] circularArray;
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(Class<T> type) {
		circularArray = (T[]) Array.newInstance(type, staticSize);
	}

	/***
	 * Add element to the circular queue 
	 */
	@Override
	public boolean enqueue(T element) {
		if (isFull()) {
			throw new RuntimeException("circular Array is full");
		}
		if (headIndex == -1) {
			headIndex = 0; tailIndex = 0;
		} else {
			tailIndex = (tailIndex + 1) % circularArray.length;
		}
		boolean elementEnqueued = false;
		// TODO code to throw an exception when the array is full
		circularArray[tailIndex] = element;
		elementEnqueued = true;
		return elementEnqueued;
	}

	@Override
	public T dequeue() {
		if (isEmpty())
			throw new RuntimeException("Queue is empty, enqueue is not performed yet");
		// TODO code to throw an exception when the 
		//cicularArray has become empty again 
		headIndex = (headIndex + 1) % circularArray.length;
		return circularArray[headIndex];
	}

	@Override
	public T peek() {
		if (headIndex == -1) 
			return null;
		return circularArray[headIndex];
	}

	@Override
	public boolean offer(T element) {
		if (isFull()) 
			return false;
		headIndex = (headIndex + 1) % circularArray.length;
		circularArray[headIndex] = element;
		return true;
	}

	@Override
	public boolean isEmpty() {
		return (headIndex == -1);
	}

	@Override
	public boolean isFull() {
		if (tailIndex == -1) 
			return false;
		int nextIndex = (tailIndex + 1) % circularArray.length;
		return (nextIndex == headIndex);
	}

}
