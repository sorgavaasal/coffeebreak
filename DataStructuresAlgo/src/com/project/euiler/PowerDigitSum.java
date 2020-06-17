package com.project.euiler;
	
import java.math.BigInteger;

/**
 * Power digit sum - problem 16
 * 2 power 15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * what is the sum of the digits of the number 2 power 1000
 * @author srividhya
 *
 */
public class PowerDigitSum {
	
	public static void main(String[] args) {
		
		BigInteger powerResult = BigInteger.ONE;
		BigInteger sum = BigInteger.ZERO;
		
		for (int i = 1; i <= 1000; ++i) {
			powerResult = powerResult.multiply(BigInteger.TWO);
		}
		
		System.out.println(powerResult);
		
		while (powerResult.compareTo(BigInteger.ZERO) > 0) {
			sum = powerResult.mod(BigInteger.TEN).add(sum);
			powerResult = powerResult.divide(BigInteger.TEN);
			System.out.println(sum + "<===>" +powerResult);
		}
		
	} 
}
