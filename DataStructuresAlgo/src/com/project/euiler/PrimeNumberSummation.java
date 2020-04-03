package com.project.euiler;

import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

/***
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.

problem number 10
 * @author srividhya
 *
 */
public class PrimeNumberSummation {
	
	public static void printPrimeNumberSummation(int rangeLimit) {
		
//		List<Integer> intNums = IntStream.rangeClosed(1, rangeLimit).boxed().
//				filter(a -> isPrime(a)).collect(toList());
		Long sum = IntStream.rangeClosed(1, rangeLimit).boxed().filter(a -> isPrime(a)).mapToLong(a -> a).sum();
		//long sum = intNums.stream().mapToInt(a -> a).sum();
		//System.out.println(intNums);
//		long sum = 0;
//		for (int i=0; i < rangeLimit; ++i) {
//			if (isPrime(i)) {
//				sum += i;
//			}
//		}
		System.out.println("sum of all integers ===>" +sum);
	}
	
	public static boolean isPrime(int num) {
		
		if (num == 0 || num == 1) {
			return false;
		}
		
		if (num == 2) return true;
		
		for (int i=2; i<num; ++i) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		printPrimeNumberSummation(2000000);
		//1179908154
		//142913828922
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		System.out.println("TimeTaken===>" +timeTaken);
	}

}
