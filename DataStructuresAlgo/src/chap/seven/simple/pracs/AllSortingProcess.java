package chap.seven.simple.pracs;

import java.util.Arrays;

public class AllSortingProcess {

	private Integer[] elements;
	
	public AllSortingProcess(Integer length) {
		elements = new Integer[length];
	}
	
	/**
	 * initialize the array with random numbers 
	 */
	public void initializeElements() {
		int length = elements.length;
		elements =  new Integer[length];
		for (int i = 0; i < elements.length; ++i) {
			int random = (int) (Math.random() * 10);
			elements[i] = random;
		}
	}
	
	/**
	 * print the content of the array 
	 */
	private void printElementContent() {
		System.out.print("ArrayContents ===> ");
		Arrays.stream(elements).forEach(System.out::print);
		System.out.println();
	}
	
	/**
	 * swap elements
	 * @param i
	 * @param j
	 */
	private void swapElements(int i, int j) {
		int tempElement = elements[j];
		elements[j] = elements[i];
		elements[i] = tempElement;

	}
	
	/**
	 * Simple logic written for checking selectionSort,
	 * this is used for 
	 */
	public void performSelectionSort() {
		for (int i = 0; i < elements.length; ++i) {
			for (int j = i; j < elements.length; ++j) {
				if (elements[i] > elements[j]) {
					swapElements(i, j);
				}
			}
		}
	}
	
	public void performBubbleSort() {
		boolean swapped = false;
		for (int i = 0; i < elements.length -1; ++i ) {
			swapped = false;
			for (int j = elements.length -1; j > i; --j) {
				if (elements[j] <= elements[j - 1]) {
					swapElements(j, j - 1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}
	
	public void performInsertionSort() {
		for (int i = 0; i < elements.length-1; ++i) {
			for (int j = i + 1; j > 0; --j) {
				if (elements[j] < elements[j -1]) {
					swapElements(j, j -1);
				} else {
					break;
				}
			}
		}
 	}
	
	private void performInsertionSort(int startIndex, int increament) {
		for (int i = startIndex; i < elements.length - 1; i = i + increament) {
			for (int j = Math.min(i + increament, elements.length - 1); j - increament >= startIndex; j = j - increament) {
				if (elements[j] < elements[j - increament]) {
					swapElements(j, j - increament);
				} else {
					break;
				}
			}
		}
	}
	
	public void performShellSort() {
		int increament = elements.length / 2;
		while (increament > 0) {
			for (int startIndex = 0; startIndex < increament; ++startIndex) {
				performInsertionSort(startIndex, increament);
			}
			increament = increament - 1;
		}
	}
	
	public void performMergeSort() {
		MergeSorting.mergeSort(elements);
	}
	
	public static void main(String[] args) {
		//below lines of code for testing selection sort
		AllSortingProcess sorting = new AllSortingProcess(10);
		
		System.out.println("====> Selection Sort");
		sorting.initializeElements();
		sorting.printElementContent();
		sorting.performSelectionSort();
		sorting.printElementContent();
		
		System.out.println("====> bubbleSort");
		sorting.initializeElements();
		sorting.printElementContent();
		sorting.performBubbleSort();
		sorting.printElementContent();
		
		System.out.println("====> insertion sort");
		sorting.initializeElements();
		sorting.printElementContent();
		sorting.performInsertionSort();
		sorting.printElementContent();
		
		System.out.println("====> shell sort");
		sorting.initializeElements();
		sorting.printElementContent();
		sorting.performShellSort();
		sorting.printElementContent();
		
		System.out.println("====> merge sort");
		sorting.initializeElements();
		sorting.printElementContent();
		sorting.performMergeSort();
		sorting.printElementContent();

	}
	
	
	

}
