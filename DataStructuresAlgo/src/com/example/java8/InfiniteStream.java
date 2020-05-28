package com.example.java8;

import java.util.Optional;
import java.util.stream.Stream;

public class InfiniteStream {
	
	public static void main(String[] args) {
		Optional<Integer> optResult =  Stream.iterate(1, n -> n * 2).limit(20).reduce(Integer::max);
		System.out.println("maximum value from the integer list ");
		optResult.ifPresent(System.out::println);
		Stream.iterate(1, n -> n * 2).limit(20).forEach(n -> {System.out.print(n + " ");});
	}

}
