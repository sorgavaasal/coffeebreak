package chap.nine.simple.pracs.udemy.heap;

public class MaximumHeapSpace<T extends Comparable> extends HeapSpace {
	
	public MaximumHeapSpace(Class type) {
		super(type);
	}
	
	public MaximumHeapSpace(Class type, int size) {
		super(type, size);
	}
	
	public void percolateDown(int index, int endIndex) {
		int leftIndex = getLeftIndex(index);
		int rightIndex = getRightIndex(index); 
		
		if (leftIndex != -1 && getElementAtIndex(leftIndex).compareTo(getElementAtIndex(index)) > 0) {
			swapElements(leftIndex, index);
			percolateDown(leftIndex, endIndex);
		}
		
		if (rightIndex != -1 && getElementAtIndex(rightIndex).compareTo(getElementAtIndex(index)) > 0) {
			swapElements(rightIndex, index);
			percolateDown(rightIndex, endIndex);
		}
	}
	
	public void heapify(int endIndex) {
		int index = getParentIndex(endIndex);
		
		while (index >= 0) {
			percolateDown(index, endIndex);
			index--;
		}
	}
	
	public void insert(T value) {
		if (this.count > this.getArrayLength()) {
			throw new IllegalArgumentException(" array length exceeded ... ");
		}
		
		this.array[count] = value;
		heapify(count);
		++count;
	}
	
	/***
	 * Removes the element @ the root of the tree
	 * @return
	 */
	public T removeHighPriority() {
		T element = getElementAtHighPriority();
		array[0] = array[count - 1];
		heapify(count-1);
		--count;
		return element;
	}
	
	/**
	 * gets element @ the root of the tree, which is of the highest priority 
	 * @return
	 */
	public T getElementAtHighPriority() {
		if (this.count == 0) {
			throw new IllegalArgumentException("no elements in the heap");
		}
		return (T) this.array[0];
	}
	
}
