package chap.nine.simple.pracs.udemy.heap;

import java.lang.reflect.Array;

/**
 * skeleton heapspace to be used by both 
 * minimum heap and maximum heap space classes 
 * @author srividhya
 */
public abstract class HeapSpace<T extends Comparable<T>> {
	
	private static Integer MAX_SIZE = 40;
	protected T[] array;
	protected int count = 0;
	
	public HeapSpace(Class type) {
		this(type, MAX_SIZE);
	}
	
	public HeapSpace(Class type, int size) {
		array = (T[]) Array.newInstance(type, size);
	}
	
	public int getArrayLength() {
		return this.array.length;
	}
	
	/**
	 * computes the left index of the heapspace and gives the 
	 * value back to the caller 
	 * @param index
	 * @return
	 */
	public int getLeftIndex(int index) {
		int result = (2 * index) + 1;
		if (result > count) {
			return -1;
		}
		
		return result;
	}
	
	/**
	 * computes the right index of the heapspace and gives the 
	 * value back to the caller 
	 * @param index
	 * @return
	 */
	public int getRightIndex(int index) {
		int result = (2 * index) + 2;
		if (result > count) {
			return -1;
		}
		return result;
	}
	
	public int getParentIndex(int index) {
		if (index < 0 || index > count) {
			return -1;
		}
		
		return (index -1) / 2;
	}
	
	//all generic helper methods are below 
	
	/**
	 * Swaps the value mentioned in the index location mentioned in the method
	 * parameters
	 * 
	 * @param index1
	 * @param index2
	 */
	public void swapElements(int index1, int index2) {
		T tempValue = array[index1];
		array[index1] = array[index2];
		array[index2] = tempValue;
	}
	
	/**
	 * gets the current count value of the Heap Array
	 * @return
	 */
	public int getCount() {
		return this.count;
	}
	
	/**
	 * checks if the heapspace is empty or has value in them 
	 * @return
	 */
	public boolean isEmpty() {
		return this.count == 0;
	}

	/***
	 * checks if the heap space is full 
	 * @return
	 */
	public boolean isFull() {
		return this.count == MAX_SIZE;
	}
	
	/**
	 * returns the element at the array index, 
	 * if the arrayindex value is greater than count exception is thrown 
	 * @param indexInput
	 * @return
	 */
	public T getElementAtIndex(int indexInput) {
		if (indexInput > count) {
			throw new IllegalArgumentException("index out of range ");
		}
		
		return array[indexInput];
	}
}
