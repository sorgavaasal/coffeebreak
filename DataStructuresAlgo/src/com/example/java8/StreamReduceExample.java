package com.example.java8;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class StreamReduceExample {

	public static void main(String[] args) {
		//*
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		//*java 7 way of finding the sum of all numbers in the array 
		int sum = 0;
		for (int num : numbers) 
			sum = sum + num;
		System.out.println("sum of all the numbers " +sum);
		
		//*java 8 way of finding the sum of the array using reduce method 
		sum = Arrays.stream(numbers).reduce(0, (a,b) -> a + b);
		System.out.println(" sum of all the numbers java8 way " +sum);
		System.out.println("Hoorraay answer matching with java 7 way ");
		
		//*another java 8 way using the Arrays stream inbuilt method 
		System.out.println(Arrays.stream(numbers).sum());
		
		OptionalInt minOpt = Arrays.stream(numbers).reduce(Integer::min);
		System.out.println(minOpt.getAsInt());
		
		
	}
}
