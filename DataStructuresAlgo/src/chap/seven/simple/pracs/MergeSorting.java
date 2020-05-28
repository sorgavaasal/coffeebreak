package chap.seven.simple.pracs;

public class MergeSorting {
	
	public static void splitElements(Integer[] elements, Integer[] firstHalfList, Integer[] secondHalfList) {
		int secondHalfIndex = firstHalfList.length;
		for (int i = 0; i < elements.length ; ++i) {
			if (i < firstHalfList.length) {
				firstHalfList[i] = elements[i];
			} else {
				secondHalfList[i - secondHalfIndex] = elements[i];
			}
		}
	}
	
	public static void mergeElements(Integer[] elements, Integer[] firstHalfList, Integer[] secondHalfList) {
		int firstHalfIndex = 0;
		int secondHalfIndex = 0;
		int index = 0;

		while (firstHalfIndex < firstHalfList.length && secondHalfIndex < secondHalfList.length) {

			if (firstHalfList[firstHalfIndex] < secondHalfList[secondHalfIndex]) {
				elements[index] = firstHalfList[firstHalfIndex];
				++firstHalfIndex;
			} else {
				elements[index] = secondHalfList[secondHalfIndex];
				++secondHalfIndex;
			}

			++index;
		}

		if (firstHalfIndex < firstHalfList.length) {
			while (index < elements.length) {
				elements[index] = firstHalfList[firstHalfIndex];
				++index;
				++firstHalfIndex;
			}
		}

		if (secondHalfIndex < secondHalfList.length) {
			while (index < elements.length) {
				elements[index] = secondHalfList[secondHalfIndex];
				++index;
				++secondHalfIndex;
			}
		}

	}
	
	public static void mergeSort(Integer[] elements) {
		if (elements.length == 1) 
			return;
		int midPoint = elements.length / 2 + elements.length % 2;
		Integer[] firstHalfList = new Integer[midPoint];
		Integer[] secondHalfList = new Integer[elements.length - midPoint];
		splitElements(elements, firstHalfList, secondHalfList);
		mergeSort(firstHalfList);
		mergeSort(secondHalfList);
		mergeElements(elements, firstHalfList, secondHalfList);
	}
}
