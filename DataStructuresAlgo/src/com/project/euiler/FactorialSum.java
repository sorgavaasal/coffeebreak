package com.project.euiler;

import java.math.BigInteger;

/**
 * Factorial digit sum Project Euler # 20
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!
 * @author srividhya
 *
 */
public class FactorialSum {

	public static void main(String[] args) {
		BigInteger factorial = BigInteger.ONE;
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i <= 100; ++i) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		
		System.out.println(factorial);
		while (factorial.compareTo(BigInteger.ZERO) > 0) {
			sum = sum.add(factorial.mod(BigInteger.TEN));
			factorial = factorial.divide(BigInteger.TEN);
			System.out.println(sum + " <===> " +factorial);
		}
			
	}

}
