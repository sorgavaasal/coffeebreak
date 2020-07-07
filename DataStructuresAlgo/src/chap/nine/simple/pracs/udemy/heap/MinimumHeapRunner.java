package chap.nine.simple.pracs.udemy.heap;

import java.util.Arrays;

/**
 * uses the MinimumHeapSpace class to build one, which can then be used 
 * for exercises 
 * @author srividhya
 *
 */
public class MinimumHeapRunner {
	
	private static final Integer[] input = { 5, 8, 6, 9, 12, 11, 7, 15, 10 };
	private static MinimumHeapSpace<Integer> minimumHeap = new MinimumHeapSpace<>(Integer.class, 40);

	/**
	 * adds the static inputArray to the minimum and returns it to the caller 
	 * @return
	 */
	public static MinimumHeapSpace<Integer> giveMinimumIntegerSpace() {
		Arrays.stream(input).forEach(num -> minimumHeap.insert(num));
		return minimumHeap;
	}	
	
	/**
	 * This method is used to find the maximum element from the minimum Heap 
	 */
	public static void findMaximumElementFromMinimumHeap() {
		//Integer lastParentElement = (Integer) minimumHeap.getElementAtIndex(minimumHeap.getArrayLength() - 1);
		Integer lastIndex = minimumHeap.getCount() - 1;
		Integer parentIndex = minimumHeap.getParentIndex(lastIndex);
		Integer maximumElement = (Integer) minimumHeap.getElementAtIndex(parentIndex + 1);
		
		for (int i = parentIndex; i < minimumHeap.getCount()-1; ++i) {
			Integer element = (Integer) minimumHeap.getElementAtIndex(i);
			if (element > maximumElement) {
				maximumElement = element;
			} else {
				continue;
			}
		}
		System.out.println("MaximumElement ===>" +maximumElement);
		
	}
	
	public static void main(String[] args) {
		giveMinimumIntegerSpace();
		findMaximumElementFromMinimumHeap();
	}

}
