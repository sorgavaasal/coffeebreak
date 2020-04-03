package chap.five.simple.pracs;

import java.util.Arrays;

public class ReverseArrayRecurrsive {
	
	private static void reverseArray(int[] data, int low, int high) {
		if (low > high) {
			return;
		} else {
			int temp = data[low];
			data[low] = data[high];
			data[high] = temp;
			reverseArray(data, low+1, high-1);
		}
	}
	
	public static void main(String[] args) {
		int[] simpleSortedIntArr =  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		reverseArray(simpleSortedIntArr, 0, simpleSortedIntArr.length-1);
		Arrays.stream(simpleSortedIntArr).forEach
			(n -> {System.out.print(n + " ");});
	}

}
