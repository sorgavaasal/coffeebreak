package com.example.java8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IntegerSumPreJava8Way {
	
	public static void sumInterator(List<Integer> intList) {
		Iterator<Integer> numIterator = intList.iterator();
		int sum = 0;
		int num = 0;
		while (numIterator.hasNext()) {
			num = numIterator.next();
			if (num > 10) {
				sum = sum + num;
			}
		}
		System.out.println("sum of all numbers greater than 10 " +sum);
	}
	
	/**
	 * java 8 stream api to filter the input and map to caclulate the 
	 * sum of the integers 
	 * @param intList
	 */
	public static void sumStreamCalc(List<Integer> intList) {
		System.out.println(intList.stream().filter(i -> i > 10).mapToInt(i -> i).sum());
	}
		
	
	public static void main(String[] args) {
		sumInterator(Arrays.asList(10, 9, 11, 11, 12, 9));
		sumStreamCalc(Arrays.asList(10, 9, 11, 11, 12, 9));
	}

}
