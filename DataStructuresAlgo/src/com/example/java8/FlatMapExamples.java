package com.example.java8;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapExamples {
	
	private static final List<String> stringLists = Arrays.asList("Shawshank redemption", "Road To Perdition",
			"Django UnChanined");
	
	public FlatMapExamples() {
		
	}
	
	public static void main(String[] args) {
		List<Stream<String>> charLists = stringLists.stream().map(str -> str.split("")).map(Arrays::stream)
				.collect(toList());

		charLists.forEach(streamsLists -> {
				streamsLists.forEach(str -> System.out.print(str));
			});
		
		System.out.println();
		//*same as above, however by using flatMap its giving arrays of String
		//*avoiding iterating the array lists
		List<String> indvCharLists = stringLists.stream().map(str -> str.split("")).flatMap(Arrays::stream)
				.collect(toList());
		
		indvCharLists.forEach(str -> System.out.print(str));
		
		List<Integer> intNumbers = Arrays.asList(2,4,6,8,10,12);
		List<Integer> squareNumbres = intNumbers.stream().map(number -> number * number).collect(toList());
		
		squareNumbres.forEach(ints -> {
			System.out.print(ints);
			System.out.print(" ");
			});
	}

}
