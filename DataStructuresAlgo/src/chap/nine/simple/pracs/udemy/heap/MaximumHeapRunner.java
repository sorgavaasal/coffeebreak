package chap.nine.simple.pracs.udemy.heap;

import java.util.Arrays;

/**
 * 
 * @author srividhya
 *
 */
public class MaximumHeapRunner {

	private static final Integer[] input = { 5, 8, 6, 9, 12, 11, 7, 15, 10 };
	private static MaximumHeapSpace<Integer> maximumHeap = new MaximumHeapSpace<>(Integer.class, 40);
	
	
	public static void main(String[] args) {
		Arrays.stream(input).forEach(num -> maximumHeap.insert(num));
		Arrays.stream(maximumHeap.array).forEach(num -> {
			if (num != null)
				System.out.print(num + " ");
		});
	}
	

}
