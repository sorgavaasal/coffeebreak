package com.example.java8;

import java.util.stream.Stream;

public class FibonacciTuples {

	private static void printFiboTuple() {
		Stream.iterate(0, n -> n +2).limit(21).forEach(n -> System.out.print(n + " "));
		System.out.println();
		Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0]+t[1]})
		.limit(21)
		.forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
	}
	
	public static void main(String[] args) {
		printFiboTuple();
	}
}
