package com.example.java8;

import java.util.Arrays;
import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.stream.Stream;

/**
 * flattenning practise and example 
 * @author srividhya
 *
 */

public class StringLengthInList {
	public static void main(String[] args) {
		List<String> stringList = Arrays.asList("java8", "string", "stream", "map", "helloworld");
		
		List<Integer> stringLen = stringList.stream().map(String::length).collect(toList());
		//stringLen.forEach(System.out::println);
		
		//System.out.println(stringList.stream().map(word -> word.split("")).collect(toList()));
		List<Stream<String>> flatStringList = stringList.stream()
				.map(word -> word.split(""))
				.map(Arrays::stream)
				.collect(toList());
		
		//*flat map example, 
		//*1. below foreach is going to get a list of stream
		//* in the first stream and the flatmap we are 
		//* going to stream line all the charaecters in a single stream
		//* which is later collected into the charList List
		List<String> charList = stringList.stream()
				.map(word -> word.split(""))
				.flatMap(Arrays::stream)
				.collect(toList());
				
		charList.forEach(System.out::print);
		System.out.println();
		
		//*2. below foreach is a split of the above logic
		//* gets a flatmap of the stream list from the flapmap
		//* later the singleStream is collected into a list of String
		Stream<String> singleStream = stringList.stream()
				.map(word->word.split(""))
				.flatMap(Arrays::stream);
		System.out.println("hashcode of the singleStreamed object===>" +singleStream);
		List<String> charListFirst = singleStream.collect(toList());

		System.out.println("list output of the singly streamed from the above step");
		System.out.println(charListFirst);
		
		//*3. 
		//Stream<Object> charArrayStream = stringList.stream().map(word -> word.chars());
		//charArrayStream.
		
		/*List<Character> charListLiteral = charListFirst.stream()
				.map(word -> word.toCharArray())
				.flatMap(Arrays::Character).collect(toList());*/
	}
}
