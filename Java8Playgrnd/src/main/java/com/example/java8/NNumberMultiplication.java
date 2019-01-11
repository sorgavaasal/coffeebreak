package com.example.java8;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * Multiplication of "N" numbers with simple stream examples 
 * @author srividhya
 *
 */
public class NNumberMultiplication {
	
	private void calculateNNumberFact(Integer num) {
		
		IntSupplier fact = new IntSupplier() {
			
			Integer nextNum = 1; Integer numFactorial = 1;			
			@Override
			public int getAsInt() {
				numFactorial = numFactorial * nextNum;
				if (nextNum <= num) 
					++nextNum;
				return numFactorial;				
			}
		};
 		
		System.out.println(IntStream.generate(fact).limit(num).max().getAsInt());
	}
	
	public static void main(String[] args) {
		new NNumberMultiplication().calculateNNumberFact(6);
	}

}
