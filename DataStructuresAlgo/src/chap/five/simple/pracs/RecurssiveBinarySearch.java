package chap.five.simple.pracs;

public class RecurssiveBinarySearch {
	
	private static boolean searchEleBinaryWay(int[] data, int low, int high, int target) {
		
		int mid = (low + high) / 2;
		
		if (low > high) 
			return false;
		
		
		if (target == data[mid]) 
			return true;
		
		
		if (target > data[mid]) {
			return searchEleBinaryWay(data, mid+1, high, target);
		} else {
			return searchEleBinaryWay(data,low, mid, target);
		}
	}
	
	public static void main(String[] args) {
		int[] simpleSortedIntArr =  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		System.out.println(searchEleBinaryWay(simpleSortedIntArr, 0, simpleSortedIntArr.length-1, 1));
	}
}
