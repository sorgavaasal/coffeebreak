package com.project.euiler;

import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

public class FibonacciCalculation {
	
	private static Integer calculateFibonacci(int num) {
		
		int result = 0;
		
		IntSupplier intSupplier = new IntSupplier() {
			
			int prevNum = 0; int nextNum = 0; int currNum = 1;

			@Override
			public int getAsInt() {
				nextNum = prevNum + currNum;
				prevNum = currNum; 
				currNum = nextNum;
				return currNum;
			}
			
		};
		
		for (int i = 1; i <= num; ++i) {
			result = intSupplier.getAsInt();
			System.out.print(result + ", ");
		}
		System.out.println();
		return result;
	}
	
	private static long calculateEvenFibonacci(long num) {
		long evenFiboNum = 0;
		long result = 0;
		long number2 = 2;
		long zeroLong = 0;
		
		LongSupplier intSupplier = new LongSupplier() {
			long prevNum = 0; long nextNum = 0; long currNum = 1;
			@Override
			public long getAsLong() {
				nextNum = prevNum + currNum;
				prevNum = currNum; 
				currNum = nextNum;
				return currNum;
			}
		};
		
		for (long i = 0; i < num; ++i) {
			if (result < num) {
				result = intSupplier.getAsLong();
				if (result % number2 == zeroLong) {
					evenFiboNum = evenFiboNum + result;
				}
			} else {
				return evenFiboNum;
			}
		}
	
		return evenFiboNum;
	}

	public static void main(String[] args) {
		System.out.println("result of Fibonacci numbers " +calculateFibonacci(10));
		long fourMillion = 4000000;
		System.out.println("result of even Fibonacci numbers " +calculateEvenFibonacci(fourMillion));
	}
}
