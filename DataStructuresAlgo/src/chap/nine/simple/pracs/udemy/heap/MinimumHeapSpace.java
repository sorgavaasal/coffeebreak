package chap.nine.simple.pracs.udemy.heap;

public class MinimumHeapSpace<T extends Comparable> extends HeapSpace {

	public MinimumHeapSpace(Class type) {
		super(type);
	}
	
	public MinimumHeapSpace(Class type, int size) {
		super(type, size);
	}
		
	/**
	 * moves down the value from the incorrect index location
	 * to the leaf node of the index
	 * @param index
	 * @return
	 */
	public int siftDown(int index) {
		int leftIndex = getLeftIndex(index);
		int rightIndex = getRightIndex(index);
		
		int smallIndex = -1;
		if (leftIndex != -1 && rightIndex != -1) {
			smallIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 ? leftIndex : rightIndex;
		} else if (leftIndex != -1) {
			smallIndex = leftIndex;
		} else if (rightIndex != -1) {
			smallIndex = rightIndex;
		}
	
		if (getElementAtIndex(smallIndex).compareTo(getElementAtIndex(index)) < 0) {
			swapElements(smallIndex, index);
			siftDown(smallIndex);
		}
		
		return smallIndex;
	}
	
	/**
	 * siftUp the value the leaf node above if the 
	 * value in the leaf node is less and should point up to the root
	 * @param index
	 * @return
	 */
	public int siftUp(int index) {
		
		int parentIndex = getParentIndex(index);
		
		if (parentIndex != -1) {
			if (getElementAtIndex(parentIndex).compareTo(getElementAtIndex(index)) > 0) {
				swapElements(parentIndex, index);
				siftUp(parentIndex);
			}
		}
		
		return parentIndex;
	}
	
	/**
	 * Adds an element to the leaf of the tree
	 * 
	 * @param value
	 */
	public void insert(int value) {
		if (this.count >= this.array.length) {
			throw new IllegalArgumentException("the number of elements in the underlying array has reached the limit");
		}

		array[count] = value;
		siftUp(count);
		++count;
	}
	
	/***
	 * Removes the element @ the root of the tree
	 * @return
	 */
	public T removeHighPriority() {
		T element = getElementAtHighPriority();
		array[0] = array[count - 1];
		siftDown(0);
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
