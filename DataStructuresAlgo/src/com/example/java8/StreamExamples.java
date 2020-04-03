package com.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StreamExamples {

	public static void main(String[] args) {
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		
		List<String> strings = 
				Arrays.asList("A", "AB", "", "ABC", "ABCD", " ", 
						"ABCDE", "ABCDEF", "  ", 
						"ABCDEFG", "ABCDEFGH", "   ");
		strings.stream().limit(5).forEach(System.out::println);

	}
}
