package com.project.euiler;

public class SumSquareNumbers {
	
	public static void getSumSquareNum() {
		
		int sumSquare = 0;
		int sum = 0;
		
		for (int i=1; i<=100; ++i) {
			sumSquare = sumSquare + (i * i);
			sum = sum + i;
		}
		
		int squareOfSum = sum * sum;
		System.out.println("sumSquare " +sumSquare);
		System.out.println("squareOfSum " +squareOfSum);
		System.out.println("Difference Between above two" +(squareOfSum-sumSquare));
	}
	
	public static void main(String[] args) {
		getSumSquareNum();
	}

}
