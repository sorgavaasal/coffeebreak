package com.example.java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamBuildingExamples {
	
	public static void main(String[] args) {
		Stream<String> staticStream = Stream.of("java8", "examples", "powerful", "for", "functional", "Programming");
		//*prints the static string in the console 
		//staticStream.forEach(System.out::println);
		
		//*convert the strings to upper case 
		staticStream = Stream.of("java8", "examples", "powerful", "for", "functional", "Programming");
		//staticStream.map(String::toUpperCase).forEach(System.out::println);;
		
		//*Streams from arrays 
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		int sum = Arrays.stream(numbers).sum();
		System.out.println("sum of all numbers array " +sum);
		
		int evenNumbersSum = Arrays.stream(numbers).filter(i -> i % 2 == 0).sum();
		System.out.println("sum of all even numvers " +evenNumbersSum);
		
		int evenNumSqrSum = Arrays.stream(numbers).filter(i -> i % 2 == 0).map(i -> i * i).sum();
		System.out.println(" sum of all even number square sum " +evenNumSqrSum);
	}

}
